package com.kb.zipkim.domain.prop.controller;

import com.kb.zipkim.domain.login.dto.CustomOAuth2User;
import com.kb.zipkim.domain.prop.dto.*;
import com.kb.zipkim.domain.complex.entity.Complex;
import com.kb.zipkim.domain.prop.entity.Property;
import com.kb.zipkim.domain.prop.repository.ComplexPropQueryRepository;
import com.kb.zipkim.domain.complex.repository.ComplexRepository;
import com.kb.zipkim.domain.prop.service.PropertyService;
import com.kb.zipkim.global.exception.AuthException;
import com.kb.zipkim.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PropertyController {

    private final PropertyService propertyService;
    private final ComplexRepository complexRepository;
    private final ComplexPropQueryRepository complexPropQueryRepository;

    @PostMapping("/api/property")
    public RegisterResult createProp(@ModelAttribute PropRegisterForm propRegisterForm, @AuthenticationPrincipal CustomOAuth2User user) throws IOException {
        if(user == null) throw new AuthException(ExceptionCode.WITHOUT_TOKEN);
        return propertyService.registerProp(propRegisterForm, user.getName());
    }


    @GetMapping("/api/prop-list")
    public Page<SimplePropInfo> PropList(@RequestParam Long complexId, Pageable pageable) {
        return propertyService.findPropList(complexId, pageable);
    }

    @GetMapping("/api/prop/{id}")
    public Property getProp(@PathVariable Long id) {
        //미완성
        return propertyService.findPropById(id);
    }

}
