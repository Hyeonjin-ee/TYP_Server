package com.travelserver.typ.domain.place.service;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.repository.PlaceRepository;
import com.travelserver.typ.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {

    @Autowired
    private final PlaceRepository placeRepository;

    public Place getPlace(Integer placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("선택할 수 없는 지역입니다.");
                });
        return place;
    }

    public Place updatePlaceAreaId(Area area, Place place){
        place.update(area);
        return place;
    }
}
