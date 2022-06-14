package com.travelserver.typ.csvprocessor;

import com.travelserver.typ.csvprocessor.dto.PlaceCsvDto;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlaceRepository placeRepository;
    private final PlaceCsvReader placeCsvReader;
//    private final PlaceCsvProcessor placeCsvProcessor;
    private final PlaceCsvWriter placeCsvWriter;

    private static final int chunkSize = 50;

    @Bean
    public Job csvFileItemReaderJob() {
        return jobBuilderFactory.get("csvFileItemReaderJob")
                .start(csvFileItemReaderStep())
                .build();
    }

    @Bean
    public Step csvFileItemReaderStep() {
        return stepBuilderFactory.get("csvFileItemReaderStep")
                .<PlaceCsvDto, PlaceCsvDto>chunk(chunkSize)
                .reader(placeCsvReader.csvFileItemReader())
//                .processor(placeCsvProcessor)
                .writer(placeCsvWriter)
                .build();
    }

}
