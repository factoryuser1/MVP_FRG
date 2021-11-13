package com.mvp.crud.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "soldier")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class SoldierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "Soldier first name cannot be empty")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Soldier last name cannot be empty")
    private String lastName;
    @Column(name = "soldier_rank", nullable = false)
    private String soldierRank;
    @Column(name = "email", nullable = false)
    @NotBlank(message = "Soldier email cannot be empty")
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
    /*
    to add later
    private LocalDateTime soldierDateTimeaAdded = LocalDateTime.now();
    private Instant soldierDateTimeaAdded = Instant.now();
    */

    //https://www.baeldung.com/jpa-one-to-one
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "soldier_spouse",
//            joinColumns = {@JoinColumn(name = "soldier_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "spouse_id", referencedColumnName = "id")})
//    private SpouseEntity spouse;


   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "spouse_id")
   private SpouseEntity spouse;


}
