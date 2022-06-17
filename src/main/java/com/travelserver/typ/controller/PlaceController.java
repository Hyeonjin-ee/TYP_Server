package com.travelserver.typ.controller;

import com.travelserver.typ.domain.place.dto.request.PlaceCreateRequestDto;
import com.travelserver.typ.domain.place.dto.request.PlaceListByUserRequestDto;
import com.travelserver.typ.domain.place.dto.request.PlaceSearchRequestDto;
import com.travelserver.typ.domain.place.dto.response.PlaceListByUserResponseDto;

import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.service.PlaceService;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {


    /**
     * [내부 로직 처리]
     * 미리 키워드 값이 부여된 여행지 리스트에서 사용자가 선택한 키워드 내용에 따른 리스트를 조회
     *
     * 사용자가 선택한 키워드가 하나라도 있으면 리스트에 추가
     *
     * list를 3개 만들어서 숙소, 먹거리, 놀거리를 따로 받아옴 ([내부 로직 처리]를 거친 결과)
     * 숙소 - getHousestyle
     * 먹거리 - getFood, getFoodPrice
     * 놀거리 - 위의 3개 제외한 결과
     * == 조건문
     *
     * 전체 리스트는 이 3개의 리스트를 합쳐서 보여줌
     */

    @Autowired
    private final UserService userService;
    @Autowired
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

    // 여행지 검색
    @GetMapping("/search")
    @ResponseBody
    public List<Place> findByPlaceName(@RequestParam(value = "placeName") String placeName){
       return placeService.findByPlaceName(placeName);
    }
}
