package com.travelserver.typ.controller;

import com.travelserver.typ.domain.place.dto.request.PlaceListByUserRequestDto;
import com.travelserver.typ.domain.place.dto.response.PlaceListByUserResponseDto;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.service.PlaceService;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final UserService userService;
    private final PlaceService placeService;

    // keywordId를 줄 필요가 있을까? 어차피 유저에 키워드 정보 담겨있으니까...?
    @GetMapping("{userId}")
    @ResponseBody
    public PlaceListByUserResponseDto getPlaceListByUser(@PathVariable("userId") Integer userId
            , @RequestBody PlaceListByUserRequestDto dto) {

        // 유저 존재 유무 판단
        // 아이디로 회원, 비회원 판단은 아직 구현 x
        User user = userService.getUser(userId);

        // 유저가 설정한 키워드에 맞는 장소(place)들을 list에 add
        /* 큰 기준 */
        // 숙소 - houseStyle
        // 먹거리 - foodPrice, food
        // 놀거리 - 그 외

        placeService.getPlaceByUsersKeyword(userId, dto);

        return null;
    }
}
