package com.dku.council.domain.oauth.repository;

import com.dku.council.domain.oauth.model.dto.request.OauthCachePayload;
import com.dku.council.global.base.AbstractKeyValueCacheRepository;
import com.dku.council.global.config.redis.RedisKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;

@Repository
public class OauthRedisRepository extends AbstractKeyValueCacheRepository {
    protected OauthRedisRepository(StringRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        super(redisTemplate, objectMapper, RedisKeys.OAUTH_CODE_KEY);
    }

    public void cacheOauth(String clientId, OauthCachePayload cachePayload) {
        set(clientId, cachePayload, Instant.now(), Duration.ofMinutes(10));
    }
}
