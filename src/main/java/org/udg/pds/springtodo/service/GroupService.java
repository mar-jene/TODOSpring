package org.udg.pds.springtodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.udg.pds.springtodo.controller.exceptions.ServiceException;
import org.udg.pds.springtodo.entity.*;
import org.udg.pds.springtodo.repository.GroupRepository;
import org.udg.pds.springtodo.repository.TaskRepository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserService userService;

    public GroupRepository crud() {
        return groupRepository;
    }

    public Collection<Group> getGroups(Long id) {
        Optional<User> u = userService.crud().findById(id);
        if (!u.isPresent()) throw new ServiceException("User does not exists");
        Collection<Group> a = u.get().getGroups();
        System.out.println("Group service "+a);
        return u.get().getGroups();
    }

    @Transactional
    public IdObject addGroup(String name, Long userId, String description) {
        try {
            User user = userService.getUser(userId);

            Group group = new Group(name, user, description);

            group.setOwner(user);

            user.addGroup(group);

            groupRepository.save(group);
            return new IdObject(group.getId());
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an ServiceException
            // We catch the normal exception and then transform it in a ServiceException
            throw new ServiceException(ex.getMessage());
        }
    }

}
