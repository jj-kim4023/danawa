package com.example.danawa.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "ZIPCODE")
    private String zipcode;

    /** 이름 */
    @Column(name = "NAME")
    private String name;

    /** 주소 */
    @Column(name = "ADDRESS")
    private String address;

    /** 상제주소 */
    @Column(name = "ADDRESS_DETAIL")
    private String addressDetail;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "REQUEST")
    private String request;

    @Column(name = "DEFAULT")
    private Boolean isDefault;
}
