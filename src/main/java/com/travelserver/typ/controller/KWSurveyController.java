package com.travelserver.typ.controller;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyCreateRequestDto;
import com.travelserver.typ.domain.kwsurvey.dto.response.KwSurveyCreateResponseDto;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.service.KwSurveyService;
import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDto;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/keyword")
public class KWSurveyController {

    private final KwSurveyService kwSurveyService;
    private final UserService userService;

    // 유저 키워드 설정
    @PostMapping("{userId}")
    @ResponseBody
    public KwSurveyCreateResponseDto createKwInfo(@PathVariable("userId") Integer userId, @RequestBody KwSurveyCreateRequestDto dto) {

        // 유저 존재 유무 판단
        // 아이디로 회원, 비회원 판단은 아직 구현 x
        User user = userService.getUser(userId);

        // keyword create
        KwSurvey kwSurvey = kwSurveyService.createKwSurvey(dto);

        // keyword를 user에게 부여하기 (user Info update)
        userService.updateUserKwId(kwSurvey, user);

        KwSurveyCreateRequestDto kwSurveyInfoInDB = KwSurveyCreateRequestDto.builder()
                .withNum(user.getKwSurvey().getWithNum())
                .age(user.getKwSurvey().getAge())
                .houseStyle(user.getKwSurvey().getHouseStyle())
                .foodPrice(user.getKwSurvey().getFoodPrice())
                .nature(user.getKwSurvey().getNature())
                .history(user.getKwSurvey().getHistory())
                .resting(user.getKwSurvey().getResting())
                .performance(user.getKwSurvey().getPerformance())
                .culture(user.getKwSurvey().getCulture())
                .leports(user.getKwSurvey().getLeports())
                .shopping(user.getKwSurvey().getShopping())
                .food(user.getKwSurvey().getFood())
                .build();

        KwSurveyCreateResponseDto responseDto = KwSurveyCreateResponseDto.builder()
                .msg("유저 키워드 선택 완료")
                .userId(user.getUserId())
                .userName(user.getName())
                .keywordId(user.getKwSurvey().getKeywordId())
                .data(kwSurveyInfoInDB)
                .build();

        return responseDto;
    }
}
