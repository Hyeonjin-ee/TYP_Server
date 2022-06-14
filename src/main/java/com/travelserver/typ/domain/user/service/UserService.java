package com.travelserver.typ.domain.user.service;

import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDto;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.respository.UserRepository;
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
}
