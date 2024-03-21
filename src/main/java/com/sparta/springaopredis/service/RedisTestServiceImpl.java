package com.sparta.springaopredis.service;

import com.sparta.springaopredis.entity.Member;
import com.sparta.springaopredis.repository.RedisTestRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RedisTestServiceImpl implements RedisTestService {

    private final RedisTestRepositoryImpl redisTestRepository;

    @Override
    @Transactional
    public void joinMember(Member member) {
        redisTestRepository.save(member);
    }

    @Override
    @CachePut(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Transactional
    public Member updateMember(Member member, Long memberId) {
        return redisTestRepository.save(member);
    }

    @Override
    @Cacheable(value = "Member", key = "#memberId", cacheManager = "cacheManager", unless = "#result == null")
    //@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    public Member getMemberInfo(Long memberId) {
        return redisTestRepository.findOne(memberId);
    }

    @Override
    @CacheEvict(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Transactional
    public void removeMember(Long memberId) {
        Member member = redisTestRepository.findOne(memberId);
        redisTestRepository.remove(member);
    }
}