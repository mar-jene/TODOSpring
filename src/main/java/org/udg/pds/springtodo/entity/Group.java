package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Signature;

@Entity(name="usergroup")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    public Group(){
    }

    public Group(String name, User owner, String description){
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @NotNull
    @ManyToOne()
    private User owner;

    public void setOwner(User user) {
        this.owner = user;
    }

    @JsonView(Views.Private.class)
    public Long getId() { return this.id; }

    @JsonView(Views.Private.class)
    public String getName() {
        return name;
    }

    @JsonView(Views.Private.class)
    public String getDescription() {
        return description;
    }
}
