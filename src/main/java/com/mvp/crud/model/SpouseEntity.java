package com.mvp.crud.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    private Long soldierId;
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "Spouse first name cannot be empty")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Spouse last name cannot be empty")
    private String lastName;
    @Column(name = "email", nullable = false)
    @NotBlank(message = "Spouse email cannot be empty")
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

    //https://www.baeldung.com/jpa-one-to-one
//    @OneToOne(mappedBy = "spouse")
//    private SoldierEntity soldier;

    /*
    Create one to one relationship with soldier.
    Soldier owns the foreign key for spouse and @JoinColumn is used to specify the name of the column in the Spouse table
    to associate a spouse with soldier
    Do not use cascade type in soldier entity
    https://www.baeldung.com/jpa-one-to-one


    */

    @OneToOne(mappedBy = "spouse")
    private SoldierEntity soldier;

}
