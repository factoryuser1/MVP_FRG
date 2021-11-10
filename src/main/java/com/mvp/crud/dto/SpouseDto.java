package com.mvp.crud.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpouseDto {
    private Long id;
    //to join Spouse and Soldier
    private Long soldierId;
    private String firstName;
    private String lastName;
    private String email;
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
