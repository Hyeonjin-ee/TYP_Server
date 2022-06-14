package com.travelserver.typ.controller;

import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDTO;
import com.travelserver.typ.domain.user.dto.response.UserJoinResponseDTO;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // 회원 가입
    @PostMapping("/join")
    @ResponseBody
    public UserJoinResponseDTO join(@RequestBody UserJoinRequestDTO dto) {
        User user = userService.join(dto);

        UserJoinRequestDTO userInfoInDB = UserJoinRequestDTO.builder()
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .gender(user.isGender())
                .name(user.getName())
                .password(user.getPassword())
                .phoneNum(user.getPhoneNum())
                .build();

        UserJoinResponseDTO responseDto = UserJoinResponseDTO.builder()
                .msg("가입이 성공적으로 완료되었습니다 :)")
                .userId(user.getUserId())
                .data(userInfoInDB)
                .build();

        return responseDto;
    }



}
