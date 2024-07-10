package com.example.danawa.member.controller;

import com.example.danawa.member.dto.JoinRequest;
import com.example.danawa.member.service.MemberService;
import com.example.danawa.member.service.MemberServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class MemberWebController {

    private final MemberService MemberService;
    public MemberWebController(MemberService memberService) {
        this.MemberService = memberService;
    }

    @GetMapping
    public String memberWebP() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return "Member Controller";
    }
    @PostMapping("/join")
    public String Member(JoinRequest joinRequest) {

        System.out.println(joinRequest.getUsername());

        MemberServiceImpl.joinProcess(joinRequest);

        return "ok";
    }
}
