package com.study.study_springboots.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    // PHYSICALFILE_NAME 이걸 만들기 위한 파일
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
