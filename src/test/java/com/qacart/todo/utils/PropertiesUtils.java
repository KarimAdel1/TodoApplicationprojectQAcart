package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {


    public static Properties loadproperties(String filepath){
        File file = new File(filepath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;


        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading the properties");
        }

    }


}
