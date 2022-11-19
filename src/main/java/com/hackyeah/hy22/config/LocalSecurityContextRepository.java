package com.hackyeah.hy22.config;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class LocalSecurityContextRepository implements SecurityContextRepository {
    public static final String GENERATED_BEARER_TOKEN = "GENERATED_BEARER_TOKEN";
    private final Map<String, SecurityContext> tokenContextMap = new HashMap<>();

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        if(requestResponseHolder.getRequest() != null) {
            return getBearerToken(requestResponseHolder.getRequest())
                    .map(tokenContextMap::get)
                    .orElseGet(SecurityContextHolder::createEmptyContext);
        }
        return SecurityContextHolder.createEmptyContext();
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        String token = getBearerToken(request).orElseGet(() -> String.valueOf(request.getAttribute(GENERATED_BEARER_TOKEN)));
        tokenContextMap.put(token, context);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return getBearerToken(request).filter(tokenContextMap::containsKey).isPresent();
    }

    private Optional<String> getBearerToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .filter(header -> header.contains("Bearer "))
                .map(header -> header.substring(7));
    }
}
