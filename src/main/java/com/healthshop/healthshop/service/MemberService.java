package com.healthshop.healthshop.service;

import com.healthshop.healthshop.SecurityConfig;
import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMemberByName(member);
        validateDuplicateMemberByLoginId(member);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRegDate(LocalDateTime.now());
        memberRepository.save(member);
        return member.getId();
    }

    // 중복 회원 검증 (by name)
    private void validateDuplicateMemberByName(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
    }

    // 중복 회원 검증 (by loginId)
    private void validateDuplicateMemberByLoginId(Member member) {
        List<Member> findMembers = memberRepository.findByLoginId(member.getLoginId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 단건 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
