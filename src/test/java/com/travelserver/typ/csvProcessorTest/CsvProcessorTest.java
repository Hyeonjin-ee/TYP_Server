package com.travelserver.typ.csvProcessorTest;

import com.travelserver.typ.csvprocessor.PlaceCsvReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CsvProcessorTest {

    @Autowired
    private PlaceCsvReader placeCsvReader;

    @Test
    public void csvReaderTest() throws Exception {
        placeCsvReader.csvFileItemReader();
    }
}
