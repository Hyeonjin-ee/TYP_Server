package com.travelserver.typ.domain.kwsurvey.dto.request;

import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Builder
public class KwSurveyRequestDto {

    private int age;
    private int withNum;
    private int houseStyle;
    private int foodPrice;
    private int nature;
    private int history;
    private int culture;
    private int performance;
    private int shopping;
    private int leports;
    private int resting;
    private int food;

    // 설문내용 저장
    public KwSurvey toEntity() {
        return KwSurvey.builder()
                .age(age)
                .withNum(withNum)
                .houseStyle(houseStyle)
                .foodPrice(foodPrice)
                .nature(nature)
                .history(history)
                .culture(culture)
                .leports(leports)
                .performance(performance)
                .resting(resting)
                .food(food)
                .shopping(shopping)
                .build();


        // place를 create할 떄 kw를 넣어준다. (placedto)


    }
}
