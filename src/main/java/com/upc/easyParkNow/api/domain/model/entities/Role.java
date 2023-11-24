package com.upc.easyParkNow.api.domain.model.entities;

import com.upc.easyParkNow.api.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    public String getStringname(){return name.name();}
    public static Role getDefaultRole(){
        return new
                Role(Roles.ROLE_USER);
    }

    public Role(Roles name) {this.name=name;}
    public static Role ToRoleFromName(String name){
        return new Role(Roles.valueOf(name));
    }
    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()){
            return List.of(getDefaultRole());
        }
        return roles;
    }

}
