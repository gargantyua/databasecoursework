package com.kuptsov.databasecoursework.utils;

import com.kuptsov.databasecoursework.model.Emploer;

import java.util.Random;

public class DataGenerator {

    private final static Random RANDOM = new Random();

    public static Emploer generateEmploer() {
        return Emploer.builder()
                .title(GeneratorStaticStorage.TITLES.get(RANDOM.nextInt(10)))
                .activity(GeneratorStaticStorage.ACTIVITIES.get(RANDOM.nextInt(10)))
                .address(GeneratorStaticStorage.ADDRESSES.get(RANDOM.nextInt(10)))
                .telephone(GeneratorStaticStorage.TELEPHONES.get(RANDOM.nextInt(10)))
                .build();
    }
}
