package com.example.danawa.member.controller;

import com.example.danawa.member.dto.JoinRequest;
import com.example.danawa.member.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;

@Controller
@ResponseBody
public class MemberWebController {

    private final MemberService memberService;
    public MemberWebController(MemberService memberService) {

        this.memberService = memberService;
    }

    @PostMapping("/join")
    public String joinProcess(JoinRequest joinRequest) {

        System.out.println(joinRequest.getUsername());

        MemberService.joinProcess(joinRequest);

        return "ok";
    }

    @GetMapping("/member")
    public String memberWebP() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return "Member Controller" + username + role;
    }
}
