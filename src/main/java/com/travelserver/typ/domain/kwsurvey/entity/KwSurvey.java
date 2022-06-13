package com.travelserver.typ.domain.kwsurvey.entity;

import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.teamjoin.entity.TeamJoin;
import com.travelserver.typ.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "keyword")
public class KwSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kw_id")
    private long keywordId;

    @OneToOne(mappedBy = "kwSurvey")
    private User user;

    @OneToMany(mappedBy = "kwSurvey", cascade = CascadeType.ALL)
    private List<Place> places = new ArrayList<>();

    @Column(name = "kw_withnum")
    private int withNum;

    @Column(name = "kw_age")
    private int age;

    @Column(name = "kw_house")
    private int houseStyle;

    @Column(name = "kw_foodprice")
    private int foodPrice;

    @Column(name="kw_nature")
    private int nature;

    @Column(name="kw_history")
    private int history;

    @Column(name="kw_resting")
    private int resting;

    @Column(name="kw_performance")
    private int performance;

    @Column(name="kw_culture")
    private int culture;

    @Column(name="kw_leports")
    private int leports;

    @Column(name="kw_shopping")
    private int shopping;

    @Column(name="kw_food")
    private int food;

}
