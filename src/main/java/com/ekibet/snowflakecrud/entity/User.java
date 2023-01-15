package com.ekibet.snowflakecrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid2")
    @GenericGenerator(name = "system-uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "location")
    private String location;

    @Column(name = "active")
    private Boolean active;

    public User(String firstname, String lastname, String location, Boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.location = location;
        this.active = active;
    }
}
