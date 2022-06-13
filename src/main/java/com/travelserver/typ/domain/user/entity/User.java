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
<<<<<<< HEAD
    private String email;
    private String password;
    private String name;
    private Date brithDate;
    private String phoneNum;
    private boolean gender;
    private boolean status;
=======

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_birthdate")
    private Date brithDate;

    @Column(name = "user_phonenum")
    private String phoneNum;

    @Column(name = "user_gender")
    private boolean gender;

    @Column(name = "user_status")
    private boolean status;

    @Column(name = "user_image")
>>>>>>> 4e9953284cc14cc7e37344dfa94e47f4a19553f0
    private String userImg;
}
