package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.annotations.AutoInjectable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    private final Properties properties;

    public Injector() {
        properties = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(
                    "res/some.properties"
            );
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Injector(String configPath) {
        properties = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(
                    configPath
            );
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T inject(T object) {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                field.setAccessible(true);
                String interfaceName = field.getType().getName();
                try {
                    Class<?> implClass = Class.forName(properties.getProperty(interfaceName));
                    Object implInstance = implClass.newInstance();
                    field.set(object, implInstance);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}

