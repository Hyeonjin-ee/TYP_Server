package com.travelserver.typ.domain.kwsurvey.dto.request;

import lombok.*;

import javax.persistence.Column;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KwSurveyCreateRequestDto {

//    private int userId;
//    private long keywordId;
    private int withNum;
    private int age;
    private int houseStyle;
    private int foodPrice;
    private int nature;
    private int history;
    private int resting;
    private int performance;
    private int culture;
    private int leports;
    private int shopping;
    private int food;

}
