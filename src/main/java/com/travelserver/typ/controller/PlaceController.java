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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final UserService userService;
    private final PlaceService placeService;

    @GetMapping("{userId}/{keywordId}")
    @ResponseBody
    public PlaceListByUserResponseDto getPlaceListByUser(@PathVariable("userId") Integer userId
            , @PathVariable("keywordId") Long keywordId
            , @RequestBody PlaceListByUserRequestDto dto) {

        // 유저 존재 유무 판단
        User user = userService.getUser(userId);

        List<Place> placeList = placeService.getPlaceByArea(dto);

        List<Place> housePlaceByUser = placeService.getPlaceByUserKWAboutHouse(userId, keywordId, placeList);
        List<Place> foodPlaceByUser = placeService.getPlaceByUserKWAboutFood(userId, keywordId, placeList);
        List<Place> playPlaceByUser = placeService.getPlaceByUserKWAboutPlay(userId, keywordId, placeList);


        PlaceListByUserRequestDto requestDto = PlaceListByUserRequestDto.builder()
                .userId(userId)
                .keywordId(keywordId)
                .areaId(dto.getAreaId())
                .build();


        PlaceListByUserResponseDto responseDto = PlaceListByUserResponseDto.builder()
                .msg("사용자 키워드에 따른 여행지 리스트입니다.")
                .dto(requestDto)
                .allPlaces(placeList)
                .housePlaces(housePlaceByUser)
                .foodPlaces(foodPlaceByUser)
                .playPlaces(playPlaceByUser)
                .build();

        return responseDto;
    }
}
