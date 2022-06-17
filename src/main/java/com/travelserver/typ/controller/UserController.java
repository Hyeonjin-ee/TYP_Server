package com.travelserver.typ.controller;

import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDto;
import com.travelserver.typ.domain.user.dto.request.UserLoginRequestDto;
import com.travelserver.typ.domain.user.dto.response.UserJoinResponseDto;
import com.travelserver.typ.domain.user.dto.response.UserLoginResponseDto;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private final UserService userService;

    // 회원 가입
    @PostMapping("join")
    @ResponseBody
    public UserJoinResponseDto join(@RequestBody UserJoinRequestDto dto) {
        User user = userService.join(dto);

        UserJoinRequestDto userInfoInDB = UserJoinRequestDto.builder()
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .gender(user.isGender())
                .name(user.getName())
                .password(user.getPassword())
                .phoneNum(user.getPhoneNum())
                .build();

        UserJoinResponseDto responseDto = UserJoinResponseDto.builder()
                .msg("가입이 성공적으로 완료되었습니다 :)")
                .userId(user.getUserId())
                .data(userInfoInDB)
                .build();

        return responseDto;

    }


    // 로그인
    @PostMapping("my")
    @ResponseBody
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto dto) {
        return userService.login(dto);
    }

}
