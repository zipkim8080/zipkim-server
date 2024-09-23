package com.kb.zipkim.domain.login.controller;

import com.kb.zipkim.domain.login.dto.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kakao")
public class LoginController {
    @Autowired
    private AccessToken tokenService;

    private final String KAKAO_USER_INFO_API = "https://kapi.kakao.com/v2/user/info";

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> kakaoLogin(@RequestParam(required = false) String token,
                                             @RequestBody(required = false) Map<String, String> requestBody) {
        String accessToken = tokenService.getAccessToken();
        if(accessToken != null && !accessToken.isEmpty()) {
            return ResponseEntity.ok("로그인 완료");
        } else {
            return ResponseEntity.ok("로그인 필요");
        }

    }
}
