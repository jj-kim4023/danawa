package com.example.danawa.member.repository;

import com.example.danawa.member.entity.Member;
import com.example.danawa.member.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<UserEntity, Long> {


    Boolean existsByUsername(String username);
    UserEntity findByUsername(String username);
}
