package com.mvp.crud.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "soldier")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //cannot be null
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "soldier_rank", nullable = false)
    private String soldierRank;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "is_married", nullable = false)
    private boolean isMarried;
    private String unit;
    private String age;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String DOB;
    private String dodId;
}
