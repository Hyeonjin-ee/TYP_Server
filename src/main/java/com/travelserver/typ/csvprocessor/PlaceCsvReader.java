package com.travelserver.typ.csvprocessor;

import com.travelserver.typ.csvprocessor.dto.PlaceCsvDto;
import com.travelserver.typ.domain.place.entity.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@RequiredArgsConstructor
@Configuration
public class PlaceCsvReader {
    @Bean
    @StepScope
    public FlatFileItemReader<PlaceCsvDto> csvFileItemReader() {

        /* file read */
        FlatFileItemReader<PlaceCsvDto> flatFileItemReader = new FlatFileItemReader<>();
        // 지역에 따라 다르게 파일 가져오고 싶음
        flatFileItemReader.setResource(new ClassPathResource("/11215.csv"));
        flatFileItemReader.setLinesToSkip(1); // header line skip
        flatFileItemReader.setEncoding("UTF-8"); // encoding

        /* read하는 데이터를 내부적으로 LineMapper을 통해 Mapping */
        DefaultLineMapper<PlaceCsvDto> defaultLineMapper = new DefaultLineMapper<>();

        /* delimitedLineTokenizer : setNames를 통해 각각의 데이터의 이름 설정 */
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
        delimitedLineTokenizer.setNames("placeId","placeName","placeAddress","category","age","withNum","houseStyle","foodPrice","nature","history","resting","performance","culture","leports","shopping","food");
        delimitedLineTokenizer.setStrict(false); // csv 파일의 컬럼과 불일치 허용

        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        /* beanWrapperFieldSetMapper : Tokenizer에서 가지고온 데이터들을 VO로 바인드하는 역할 */
        BeanWrapperFieldSetMapper<PlaceCsvDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(PlaceCsvDto.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        /* lineMapper 지정 */
        flatFileItemReader.setLineMapper(defaultLineMapper);

//        System.out.println(beanWrapperFieldSetMapper.toString());

        return flatFileItemReader;
    }
}
