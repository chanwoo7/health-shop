package com.healthshop.healthshop.repository;

import com.healthshop.healthshop.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    Member findByLoginId(String loginId);
}