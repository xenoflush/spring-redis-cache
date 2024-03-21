package com.sparta.springaopredis.service;

import com.sparta.springaopredis.entity.Member;

public interface RedisTestService {
    void joinMember(Member member);
    Member updateMember(Member member, Long memberId);
    Member getMemberInfo(Long memberId);
    void removeMember(Long memberId);
}