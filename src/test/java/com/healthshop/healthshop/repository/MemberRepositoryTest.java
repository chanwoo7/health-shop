package com.healthshop.healthshop.repository;

import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void findByLoginId() {
        String loginId = "abcdef1234";

        Member member = new Member();
        member.setName("kim");
        member.setLoginId(loginId);
        member.setPassword("example1234");

        memberService.join(member);

        assertEquals(member, memberRepository.findByLoginId(loginId));
    }
}