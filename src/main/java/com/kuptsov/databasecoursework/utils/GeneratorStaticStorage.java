package com.kuptsov.databasecoursework.utils;

import java.util.ArrayList;
import java.util.List;

public class GeneratorStaticStorage {

    public final static List<String> TITLES = new ArrayList<>();
    public final static List<String> ACTIVITIES = new ArrayList<>();
    public final static List<String> ADDRESSES = new ArrayList<>();
    public final static List<String> TELEPHONES = new ArrayList<>();

    static {
        TITLES.add("СТПК");
        TITLES.add("СинТек");
        TITLES.add("СтройДом");
        TITLES.add("ПаркТрейд");
        TITLES.add("ШифтЛайф");
        TITLES.add("Кольт");
        TITLES.add("Энерго-3");
        TITLES.add("Яндекс");
        TITLES.add("Google");
        TITLES.add("Рога и Копыта");

        ACTIVITIES.add("Магазин");
        ACTIVITIES.add("Лаборатория");
        ACTIVITIES.add("Завод");
        ACTIVITIES.add("Ресторан");
        ACTIVITIES.add("Логистика");
        ACTIVITIES.add("Такси");
        ACTIVITIES.add("Грузоперевозки");
        ACTIVITIES.add("Автосалон");
        ACTIVITIES.add("Разработка ПО");
        ACTIVITIES.add("Животноводство");

        ADDRESSES.add("ул. Ганенкова, 55");
        ADDRESSES.add("ул. Промышленная, 99");
        ADDRESSES.add("ул. Ленина, 5");
        ADDRESSES.add("пр. Автостроителей, 109");
        ADDRESSES.add("ул. Московская, 15");
        ADDRESSES.add("ул. Мориса Тереза, 5");
        ADDRESSES.add("ул. Куйбышева, 65");
        ADDRESSES.add("ул. Пронина, 10");
        ADDRESSES.add("ул. Есенина, 55");
        ADDRESSES.add("ул. Каруселина, 1");

        TELEPHONES.add("1-111-111-11-11");
        TELEPHONES.add("2-222-222-22-22");
        TELEPHONES.add("3-333-333-33-33");
        TELEPHONES.add("4-444-444-44-44");
        TELEPHONES.add("5-555-555-55-55");
        TELEPHONES.add("6-666-666-66-66");
        TELEPHONES.add("7-777-777-77-77");
        TELEPHONES.add("8-888-888-88-88");
        TELEPHONES.add("9-999-999-99-99");
        TELEPHONES.add("0-000-000-00-00");
    }
}
