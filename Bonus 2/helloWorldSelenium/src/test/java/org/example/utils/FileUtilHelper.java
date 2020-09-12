package org.example.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class FileUtilHelper {
    @SneakyThrows
    public static void makeFileWithContent(String fileName, String fileContent) {
        File destination = new File(fileName);
        destination.createNewFile();

        FileUtils.writeStringToFile(destination.getAbsoluteFile(), fileContent, StandardCharsets.UTF_8);
    }
}
