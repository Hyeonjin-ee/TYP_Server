package com.travelserver.typ.domain.place.service;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.area.repository.AreaRepository;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.repository.KwSurveyRepository;
import com.travelserver.typ.domain.place.dto.request.PlaceListByUserRequestDto;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.repository.PlaceRepository;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceService {

    private UserRepository userRepository;
    private KwSurveyRepository kwSurveyRepository;
    private PlaceRepository placeRepository;
    private AreaRepository areaRepository;


    // entity가 아니라 dto로 하는 게 맞는 것 같은데 일단,, place로
    public List<Place> getPlaceByUsersKeyword(int userId, PlaceListByUserRequestDto dto) {

        List<Place> housePlaceList = Collections.emptyList();
        List<Place> foodPlaceList = Collections.emptyList();
        List<Place> playPlaceList = Collections.emptyList();

        // 1. 유저 아이디로 유저 가져오기
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });

        // 근데 갑자기 의문이 든 게 각기 다른 사용자들의
        // 키워드 선택이 달라도 괜찮은건가 ?
        // 2. 유저를 통해서 키워드 정보 가져오기
        Long keywordId = user.getKwSurvey().getKeywordId();
        KwSurvey kwSurvey = kwSurveyRepository.findById(keywordId)
                .orElseThrow(() -> {
                    throw new NullPointerException("유저의 키워드 설정값이 없습니다.");
                });



        // 3. 해당 지역에 해당하는 place 리스트 가져오기
        // 그럼 request할 때 지역 정보를 줘야겠네...? -> ok. 추가함

        // 유저가 선택한 지역 정보 id
        Integer areaId = dto.getAreaId();
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 지역입니다.");
                });

        List<Place> allPlaceByArea = (List<Place>) placeRepository.findAllByArea(area)
                .orElseThrow(() -> {
                    throw new NullPointerException("존재하지 않는 지역입니다.");
                });


        allPlaceByArea.forEach(place -> {
            if (place.getKwSurvey().getHouseStyle() == kwSurvey.getHouseStyle()) {
                housePlaceList.add(place);
            } else if ((place.getKwSurvey().getFood() == kwSurvey.getFood()) || (place.getKwSurvey().getFoodPrice() == kwSurvey.getFoodPrice())) {
                foodPlaceList.add(place);
            } else if (place.getKwSurvey().getNature() == kwSurvey.getNature()
                    || (place.getKwSurvey().getHistory() == kwSurvey.getHistory())
                    || (place.getKwSurvey().getResting() == kwSurvey.getResting())
            ) {

            }
        });



        return null;
    }

}
