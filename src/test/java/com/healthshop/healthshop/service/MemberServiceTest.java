package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
//    @Autowired EntityManager em;

    private void setOthers(Member member) {
        member.setPassword("example123");
        // member.setRegDate(LocalDateTime.now());
        member.setIsActive(true);
    }

    @Test
//    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");
        member.setLoginId("example1");
        setOthers(member);

        //when
        Long savedId = memberService.join(member);

        //then
//        em.flush();  // insert문 확인 용도
        assertEquals(member, memberRepository.findById(savedId).orElse(null));
    }

    @Test
    public void 이름_중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");
        member1.setLoginId("example1");
        setOthers(member1);

        Member member2 = new Member();
        member2.setName("kim1");
        member2.setLoginId("example2");
        setOthers(member2);

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }

    @Test
    public void 아이디_중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");
        member1.setLoginId("example1");
        setOthers(member1);

        Member member2 = new Member();
        member2.setName("lee2");
        member2.setLoginId("example1");
        setOthers(member2);

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }

    // TODO: 회원 주소 생성

    // TODO: 기본 주소 조회

}