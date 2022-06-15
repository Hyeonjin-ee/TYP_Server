package com.travelserver.typ.domain.kwsurvey.service;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyCreateRequestDto;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.repository.KwSurveyRepository;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KwSurveyService {

    private final KwSurveyRepository kwSurveyRepository;
    private final UserRepository userRepository;

    @Transactional
    public KwSurvey createKwSurvey(KwSurveyCreateRequestDto dto) {
        String keywordIdString = Integer.toString(dto.getWithNum())
                + Integer.toString(dto.getAge())
                + Integer.toString(dto.getHouseStyle())
                + Integer.toString(dto.getFoodPrice())
                + Integer.toString(dto.getNature())
                + Integer.toString(dto.getHistory())
                + Integer.toString(dto.getResting())
                + Integer.toString(dto.getPerformance())
                + Integer.toString(dto.getCulture())
                + Integer.toString(dto.getLeports())
                + Integer.toString(dto.getShopping())
                + Integer.toString(dto.getFood());

        Long keywordId = Long.parseLong(keywordIdString);


        KwSurvey kwSurvey =  KwSurvey.builder()
                .keywordId(keywordId)
                .withNum(dto.getWithNum())
                .age(dto.getAge())
                .houseStyle(dto.getHouseStyle())
                .foodPrice(dto.getFoodPrice())
                .nature(dto.getNature())
                .history(dto.getHistory())
                .resting(dto.getResting())
                .performance(dto.getPerformance())
                .culture(dto.getCulture())
                .leports(dto.getLeports())
                .shopping(dto.getShopping())
                .food(dto.getFood())
                .build();

        return kwSurveyRepository.save(kwSurvey);
    }

}
