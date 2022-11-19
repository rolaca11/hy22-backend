package com.hackyeah.hy22.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackyeah.hy22.api.ApiToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static com.hackyeah.hy22.config.LocalSecurityContextRepository.GENERATED_BEARER_TOKEN;

@RequiredArgsConstructor
public class ReturnTokenAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = UUID.randomUUID().toString();
        request.setAttribute(GENERATED_BEARER_TOKEN, token);
        response.setContentType("application/json");
        objectMapper.writeValue(response.getOutputStream(), ApiToken.builder().token(token).build());
    }
}
