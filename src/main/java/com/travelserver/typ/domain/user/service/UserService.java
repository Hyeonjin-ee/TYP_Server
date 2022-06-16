package com.travelserver.typ.domain.user.service;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyCreateRequestDto;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.service.KwSurveyService;
import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDto;
import com.travelserver.typ.domain.user.dto.response.UserLoginResponseDto;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public User join(UserJoinRequestDto dto){

        return userRepository.save(dto.toEntity());
    }

    public UserLoginResponseDto login(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
        return UserLoginResponseDto.toDto(user);
    }


    public User getUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
        return user;
    }

    public User updateUserKwId(KwSurvey kwSurvey, User user) {
        user.update(kwSurvey);
        return user;
    }



}
