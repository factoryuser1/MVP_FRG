package com.mvp.crud.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spouse")
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class SpouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //to join SpouseEntity and SoldierEntity
//    private Long soldierId;
    //cannot be null
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "is_complete", nullable = false)
    private boolean isComplete;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String occupation;
    private String company;

    /*
    Create one to one relationship with soldier.
    Soldier owns the foreign key for spouse and @JoinColumn is used to specify the name of the column in the Spouse table
    to associate a spouse with soldier
    Do not use cascade type in soldier entity
    https://www.baeldung.com/jpa-one-to-one
    */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "soldier_id", referencedColumnName = "id")
    private SoldierEntity soldier;
}
