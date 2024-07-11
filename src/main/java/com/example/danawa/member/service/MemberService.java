package com.example.danawa.member.service;


import com.example.danawa.member.dto.JoinRequest;

public interface MemberService {
    public void save();

    void joinProcess(JoinRequest joinRequest);
}
