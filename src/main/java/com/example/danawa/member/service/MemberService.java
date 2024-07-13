package com.example.danawa.member.service;

import com.example.danawa.member.dto.JoinRequest;
import com.example.danawa.member.entity.Member;
import com.example.danawa.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private static MemberRepository memberRepository;
    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static void joinProcess(JoinRequest joinRequest) {

        String username = joinRequest.getUsername();
        String password = joinRequest.getPassword();
        Boolean isExist = memberRepository.existsByUsername(username);

        if (isExist) {

            return;
        }

        Member data = new Member();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        memberRepository.save(data);
    }


}
