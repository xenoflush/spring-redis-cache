package com.sparta.springaopredis.repository;

import com.sparta.springaopredis.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisTestRepositoryImpl {

    private final EntityManager em;

    public Member save(Member member) {
        if (member.getId() == null) {
            em.persist(member);
        } else {
            Member findMember = em.find(Member.class, member.getId());
            findMember.setName(member.getName());
        }

        return member;
    }

    public Member findOne(Long memberId) {
        return em.find(Member.class, memberId);
    }

    public void remove(Member member) {
        em.remove(member);
    }
}