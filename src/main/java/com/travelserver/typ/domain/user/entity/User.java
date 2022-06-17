package com.travelserver.typ.domain.user.entity;

import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    // Field 'user_id' doesn't have a default value error 해결 : IDENTITY -> AUTO
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @OneToOne
    @JoinColumn(name = "kw_id")
    private KwSurvey kwSurvey;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = TeamJoin.class)
//    private List<TeamJoin> teamJoins = new ArrayList<>();

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_pwd")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_birthdate")
    private Date birthDate;

    @Column(name = "user_phonenum")
    private String phoneNum;

    @Column(name = "user_gender")
    private boolean gender;

    @Column(name = "user_status")
    private boolean status;

    @Column(name = "user_image")
    private String userImg;


    public void update(KwSurvey kwSurvey) {
        this.kwSurvey = kwSurvey;
//        kwSurvey.update(this);
    }

}
