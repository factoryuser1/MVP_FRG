package com.mvp.crud.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "soldier_spouse")
public class SoldierSpouse {
    @Id
    private Long soldierId;
    @Id
    private Long spouseId;
}
