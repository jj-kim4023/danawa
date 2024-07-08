package com.example.danawa.member.controller;

import com.example.danawa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberWebController {

    @GetMapping
    public String memberWebP() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();


        return "Member Controller";
    }
}
