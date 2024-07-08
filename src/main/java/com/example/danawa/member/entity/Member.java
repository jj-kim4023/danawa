package com.example.danawa.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private LocalDate birth;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
