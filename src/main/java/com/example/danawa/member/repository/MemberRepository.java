package com.example.danawa.member.repository;

import com.example.danawa.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByUsername(String username);
    Member findByUsername(String username);
}
