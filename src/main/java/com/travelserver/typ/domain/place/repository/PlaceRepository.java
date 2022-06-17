package com.travelserver.typ.domain.place.repository;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findByArea_areaId(Integer areaId);

}
