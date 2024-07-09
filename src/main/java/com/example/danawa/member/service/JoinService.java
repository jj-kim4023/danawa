package com.example.danawa.member.service;

import com.example.danawa.member.dto.JoinDTO;
import com.example.danawa.member.entity.Member;
import com.example.danawa.member.entity.UserEntity;
import com.example.danawa.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(MemberRepository memberRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = memberRepository.existsByUsername(username);

        if (isExist) {
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_MEMBER");
        data.setEmail(joinDTO.getEmail());
        data.setPhone(joinDTO.getPhone());
        memberRepository.save(data);
    }

}
