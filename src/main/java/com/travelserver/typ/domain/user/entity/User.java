package com.travelserver.typ.domain.user.entity;

import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.teamjoin.entity.TeamJoin;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "\"user\"")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    @OneToOne
    @JoinColumn(name = "kw_id")
    private KwSurvey kwSurvey;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TeamJoin> planJoins = new ArrayList<>();

    private String email;

    private String password;

    private String name;

    private Date brithDate;

    private String phoneNum;

    private boolean gender;

    private boolean status;

    private String userImg;
}
