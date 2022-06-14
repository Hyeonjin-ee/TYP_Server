package com.travelserver.typ.csvprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class LibraryCsvReader {

    public Integer areaInt;

    /* file read */
    FlatFileItemReader<TempLibraryDto> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("E:/BigData/project/TYP_backend/src/main/resources/11215.csv"));
        flatFileItemReader.setLinesToSkip(1); // header line skip
        flatFileItemReader.setEncoding("UTF-8"); // encoding

    /* read하는 데이터를 내부적으로 LineMapper을 통해 Mapping */
    DefaultLineMapper<TempLibraryDto> defaultLineMapper = new DefaultLineMapper<>();

    /* delimitedLineTokenizer : setNames를 통해 각각의 데이터의 이름 설정 */
    DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames("placeId","placeName","category","age","withNum","house","foodPrice","nature","history",
                "resting","performance","culture","leports","shopping","food");
        delimitedLineTokenizer.setStrict(false); // csv 파일의 컬럼과 불일치 허용

        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

    /* beanWrapperFieldSetMapper : Tokenizer에서 가지고온 데이터들을 VO로 바인드하는 역할 */
    BeanWrapperFieldSetMapper<TempLibraryDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(TempLibraryDto .class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

    /* lineMapper 지정 */
        flatFileItemReader.setLineMapper(defaultLineMapper);

        return flatFileItemReader;
}
}
