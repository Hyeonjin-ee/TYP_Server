package com.travelserver.typ.domain.place.entity;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.team.entity.Team;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private int placeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kw_id")
    private KwSurvey kwSurvey;

    @OneToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_description")
    private String placeDescription;

    @Column(name = "place_address")
    private String placeAddress;

    @Column(name = "place_image")
    private String placeImage;

    @Column(name = "place_x")
    private String placeXCoordinate;

    @Column(name = "place_y")
    private String placeYCoordinate;

}
