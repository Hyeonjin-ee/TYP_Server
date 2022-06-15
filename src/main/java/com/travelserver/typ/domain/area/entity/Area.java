package com.travelserver.typ.domain.area.entity;

import com.travelserver.typ.domain.place.entity.Place;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "area")
public class Area {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private int areaId;

    @OneToOne(mappedBy = "area")
    private Place place;

    @Column(name = "area_name")
    private int areaName;

    @Column(name = " area_address")
    private String areaAddress;

    @Column(name = "area_x")
    private String areaXCoordinate;

    @Column(name = "area_y")
    private String areaYCoordinate;


}
