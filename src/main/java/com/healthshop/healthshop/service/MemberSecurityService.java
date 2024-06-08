package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.domain.member.MemberRole;
import com.healthshop.healthshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member findMember = memberRepository.findByLoginId(loginId);
        if (findMember == null) {
            throw new UsernameNotFoundException("아이디가 " + loginId + "인 사용자를 찾을 수 없습니다.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (loginId.equals("admin")) {
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
        }
        return new User(findMember.getLoginId(), findMember.getPassword(), authorities);
    }

}
