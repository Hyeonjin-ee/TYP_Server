package com.travelserver.typ.controller;

import com.travelserver.typ.domain.kwsurvey.service.KwSurveyService;
import com.travelserver.typ.domain.place.service.PlaceService;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final KwSurveyService kwSurveyService;
    private final PlaceService placeService;
    private final UserService userService;

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

}
