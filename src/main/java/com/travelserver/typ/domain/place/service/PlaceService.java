package com.travelserver.typ.domain.place.service;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.area.repository.AreaRepository;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.kwsurvey.repository.KwSurveyRepository;
import com.travelserver.typ.domain.place.dto.request.PlaceCreateRequestDto;
import com.travelserver.typ.domain.place.dto.request.PlaceListByUserRequestDto;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.repository.PlaceRepository;
import com.travelserver.typ.domain.user.entity.User;
import com.travelserver.typ.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceService {

    private final UserRepository userRepository;
    private final KwSurveyRepository kwSurveyRepository;
    private final PlaceRepository placeRepository;
    private final AreaRepository areaRepository;

    public Place createPlace(PlaceCreateRequestDto dto){
        Place place = Place.builder()
                .placeName(dto.getPlaceName())
                .placeAddress(dto.getPlaceAddress())
                .placeDescription(dto.getPlaceDescription())
                .placeXCoordinate(dto.getPlaceXCoordinate())
                .placeYCoordinate(dto.getPlaceYCoordinate())
                .build();

        return placeRepository.save(place);
    }

    public Place getPlace(Integer placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("선택할 수 없는 지역입니다.");
                });
        return place;
    }

//    public Place updatePlaceAreaId(Area area, Place place){
//        place.update(area);
//        return place;
//    }



    public List<Place> getPlaceByArea(PlaceListByUserRequestDto dto) {

        // 선택된 지역 ID
        Integer areaId = dto.getAreaId();
//        Area area = areaRepository.findById(areaId)
//                .orElseThrow(() -> {
//                    throw new IllegalArgumentException("존재하지 않는 지역입니다.");
//                });

        List<Place> placeList = new ArrayList<Place>();
        placeList = placeRepository.findByArea_areaId(areaId);
        if (placeList == null || placeList.isEmpty())
            throw new NullPointerException("존재하지 않는 지역입니다.");

        return placeList;
    }


    public List<Place> getPlaceByUserKWAboutHouse(int userId, long keywordId, List<Place> placeList) {

        List<Place> housePlaceList = new ArrayList<Place>();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });


//        Long keywordId = user.getKwSurvey().getKeywordId();
        KwSurvey kwSurvey = kwSurveyRepository.findById(keywordId)
                .orElseThrow(() -> {
                    throw new NullPointerException("유저의 키워드 설정값이 없습니다.");
                });


        placeList.stream()
                .forEach(place -> {
                    if (place.getKwSurvey().getHouseStyle() == kwSurvey.getHouseStyle()) {
                        housePlaceList.add(place);
                    }
                });

        return housePlaceList;
    }


    public List<Place> getPlaceByUserKWAboutFood(int userId, long keywordId, List<Place> placeList) {

        List<Place> foodPlaceList = new ArrayList<Place>();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });


//        Long keywordId = user.getKwSurvey().getKeywordId();
        KwSurvey kwSurvey = kwSurveyRepository.findById(keywordId)
                .orElseThrow(() -> {
                    throw new NullPointerException("유저의 키워드 설정값이 없습니다.");
                });


        placeList.stream()
                .forEach(place -> {
            if ((place.getKwSurvey().getFood() == kwSurvey.getFood()) || (place.getKwSurvey().getFoodPrice() == kwSurvey.getFoodPrice())) {
                foodPlaceList.add(place);
            }
        });

        return foodPlaceList;
    }


    public List<Place> getPlaceByUserKWAboutPlay(int userId, long keywordId, List<Place> placeList) {

        List<Place> playPlaceList = new ArrayList<Place>();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });


//        Long keywordId = user.getKwSurvey().getKeywordId();
        KwSurvey kwSurvey = kwSurveyRepository.findById(keywordId)
                .orElseThrow(() -> {
                    throw new NullPointerException("유저의 키워드 설정값이 없습니다.");
                });


        placeList.stream()
                .forEach(place -> {
            if (place.getKwSurvey().getNature() == kwSurvey.getNature()
                    || (place.getKwSurvey().getHistory() == kwSurvey.getHistory())
                    || (place.getKwSurvey().getResting() == kwSurvey.getResting())
                    || (place.getKwSurvey().getPerformance() == kwSurvey.getPerformance())
                    || (place.getKwSurvey().getCulture() == kwSurvey.getCulture())
                    || (place.getKwSurvey().getLeports() == kwSurvey.getLeports())
                    || (place.getKwSurvey().getShopping() == kwSurvey.getShopping())
                    || (place.getKwSurvey().getFood() == kwSurvey.getFood())) {
                playPlaceList.add(place);
            }
        });

        return playPlaceList;
    }
}
