package com.example.danawa.member.controller;

import com.example.danawa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@RequiredArgsConstructor
@Controller
public class MemberWebController {
    private final MemberService memberService;
    
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }
}
