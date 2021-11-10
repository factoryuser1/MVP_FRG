package com.mvp.crud.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SoldierDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String soldierRank;
    private String email;
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
