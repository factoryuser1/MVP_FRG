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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Spouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //to join Spouse and Soldier
    private Long soldierId;
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
    private String country;
    private String occupation;
    private String company;
}
