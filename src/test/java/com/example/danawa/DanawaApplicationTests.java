package com.example.danawa;

import com.example.danawa.member.entity.Member;
import com.example.danawa.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DanawaApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void crudTest() {
		Member member = Member.builder()
				.id(Long.valueOf("admin"))
				.username("aaa")
				.password("1234")
				.build();

				memberRepository.saveAndFlush(member);

				Member foundMember = memberRepository.findById(1L).get();
	}

}
