package com.khang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends Base{

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "decription")
    private String decription;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public String getRoleName() {
        return roleName;
    }

    public String getDecription() {
        return decription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role(long id, String roleName, String decription) {
        super(id);
        this.roleName = roleName;
        this.decription = decription;
    }
}
