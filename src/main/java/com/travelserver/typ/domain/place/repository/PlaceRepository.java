package com.travelserver.typ.domain.place.repository;

import com.travelserver.typ.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
