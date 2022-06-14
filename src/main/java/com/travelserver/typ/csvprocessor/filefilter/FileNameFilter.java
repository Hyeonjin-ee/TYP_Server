package com.travelserver.typ.csvprocessor.filefilter;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilter {
    public int filterProcessor(int areaInt) {
        String DATA_DIRECTORY = "E:/BigData/project/TYP_backend/src/main/resources/";

        File dir = new File(DATA_DIRECTORY);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File f, String name) {
                //파일 이름에 "mine"가 붙은것들만 필터링
                return name.contains("%d", areaInt);
            }
        };

        return areaInt;
    }
}
