package org.udg.pds.springtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Group(){
    }
    public Group(String name, String description){
        this.name = name;
        this.description = description;
    }
}
