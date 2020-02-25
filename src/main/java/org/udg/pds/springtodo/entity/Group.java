package org.udg.pds.springtodo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Signature;

@Entity(name="usergroup")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @ManyToOne()
    private User owner;

    public Group(){
    }
    public Group(String name, User owner, String description){
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public Long getId() { return this.id; }
}
