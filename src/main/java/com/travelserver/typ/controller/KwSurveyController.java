package com.travelserver.typ.controller;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyRequestDto;
import com.travelserver.typ.domain.kwsurvey.dto.response.KwSurveyResponseDto;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.service.KwSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class KwSurveyController {

    private final KwSurveyService kwSurveyService;

    // 키워드 등록
    @PostMapping("keyword")
    @ResponseBody
    public KwSurveyResponseDto selectkw(@RequestBody KwSurveyRequestDto dto) {
        KwSurvey kwSurvey = kwSurveyService.selectkw(dto);

        KwSurveyRequestDto kwInfoDB = KwSurveyRequestDto.builder()
                .age(kwSurvey.getAge())
                .withNum(kwSurvey.getWithNum())
                .houseStyle(kwSurvey.getHouseStyle())
                .foodPrice(kwSurvey.getFoodPrice())
                .nature(kwSurvey.getNature())
                .history(kwSurvey.getHistory())
                .culture(kwSurvey.getCulture())
                .leports((kwSurvey.getLeports()))
                .performance(kwSurvey.getPerformance())
                .resting(kwSurvey.getResting())
                .food(kwSurvey.getFood())
                .shopping(kwSurvey.getShopping())
                .build();

        KwSurveyResponseDto responseDto = KwSurveyResponseDto.builder()
                .msg("키워드 설정이 완료되었습니다 :)")
                .kwId(kwSurvey.getKeywordId())
                .data(kwInfoDB)
                .build();

        return responseDto;
    }
}
