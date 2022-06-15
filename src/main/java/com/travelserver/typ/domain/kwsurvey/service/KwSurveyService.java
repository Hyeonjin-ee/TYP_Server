package com.travelserver.typ.domain.kwsurvey.service;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyRequestDto;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.repository.KwSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class KwSurveyService {
    private final KwSurveyRepository kwSurveyRepository;


    @Transactional
    public KwSurvey selectkw(KwSurveyRequestDto dto){
        return kwSurveyRepository.save(dto.toEntity());
    }
}
