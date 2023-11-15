package com.sesac.project.mvc.fx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResourcesReader {

    private static final ClassLoader loader = ResourcesReader.class.getClassLoader();

    public static Properties read(String path) {
        Properties prop = new Properties();
        try (FileInputStream file = new FileInputStream(loader.getResource(path).getFile())) {
            prop.load(file);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
