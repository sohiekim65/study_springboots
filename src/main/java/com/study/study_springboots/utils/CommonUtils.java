package com.study.study_springboots.utils;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    // PHYSICALFILE_NAME 이걸 만들기 위한 파일
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // "src/main/resources/static/files/" --> root directory + 상대경로
    public String getRelativeToAbsolutePath(String relativePath) {
        String relativePathWithSeparator = relativePath.replace("/", File.separator);
        String absolutePath = new File(relativePathWithSeparator).getAbsolutePath() + File.separator; // 폴더의 경로를 가져옴
        return absolutePath;
    } 
}
