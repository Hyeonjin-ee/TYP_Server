//package com.travelserver.typ.csvprocessor;
//
//import com.travelserver.typ.csvprocessor.dto.PlaceCsvDto;
//import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
//import com.travelserver.typ.domain.kwsurvey.repository.KwSurveyRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Configuration
//public class PlaceCsvWriter implements ItemWriter<PlaceCsvDto> {
//
//    private final PlaceRepository placeRepository;
//    private final KwSurveyRepository kwSurveyRepository;
//
//    @Override
//    public void write(List<? extends PlaceCsvDto> list) throws Exception {
//        List<Place> placeList = new ArrayList<>();
//        List<KwSurvey> kwSurveyList = new ArrayList<>();
//
//        list.forEach(getPlace -> {
//            KwSurvey getKwSurvey = KwSurvey.builder()
//                    .age(getPlace.getAge())
//                    .withNum(getPlace.getWithNum())
//                    .houseStyle(getPlace.getHouseStyle())
//                    .foodPrice(getPlace.getFoodPrice())
//                    .nature(getPlace.getNature())
//                    .history(getPlace.getHistory())
//                    .resting(getPlace.getResting())
//                    .performance(getPlace.getPerformance())
//                    .culture(getPlace.getCulture())
//                    .leports(getPlace.getLeports())
//                    .shopping(getPlace.getShopping())
//                    .food(getPlace.getFood())
//                    .build();
//
//
//            kwSurveyList.add(getKwSurvey);
//
//            placeList.add(Place.builder()
//                    .placeName(getPlace.getPlaceName())
//                    .placeAddress(getPlace.getPlaceAddress())
//                    .kwSurvey(getKwSurvey)
//                    .build());
//        });
//
//        System.out.println(placeList);
//        System.out.println(kwSurveyList);
//
//        placeRepository.saveAll(placeList);
//        kwSurveyRepository.saveAll(kwSurveyList);
//    }
//}