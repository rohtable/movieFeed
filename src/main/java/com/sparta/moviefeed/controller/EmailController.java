package com.sparta.moviefeed.controller;

import com.sparta.moviefeed.dto.requestdto.EmailCheckRequestDto;
import com.sparta.moviefeed.dto.responsedto.CommonResponse;
import com.sparta.moviefeed.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping()
    public ResponseEntity<CommonResponse> sendEmail() {
        emailService.joinEmail();
        CommonResponse response = new CommonResponse(200, "인증 이메일 보내기 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<CommonResponse> checkAuthCode(@Valid @RequestBody EmailCheckRequestDto requestDto) {
        emailService.checkAuthCode(requestDto);
        CommonResponse response = new CommonResponse(200, "이메일 인증 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
