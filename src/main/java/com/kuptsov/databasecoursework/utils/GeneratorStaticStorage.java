package com.kuptsov.databasecoursework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorStaticStorage {

    public final static Integer DATASET_SIZE = 15;

    public final static List<String> TITLES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> ACTIVITIES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> ADDRESSES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> TELEPHONES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> NAMES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> SURNAMES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> PATRONYMICS = new ArrayList<>(DATASET_SIZE);
    public final static List<Integer> QUALIFICATIONS = new ArrayList<>(DATASET_SIZE);
    public final static List<String> OTHER_INFO = new ArrayList<>(DATASET_SIZE);
    public final static List<Long> SALARIES = new ArrayList<>(DATASET_SIZE);
    public final static List<String> POSITIONS = new ArrayList<>(DATASET_SIZE);
    public final static List<Long> COMMISSIONS = new ArrayList<>(DATASET_SIZE);

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
        TITLES.add("Петучи");
        TITLES.add("КВН");
        TITLES.add("Tesla");
        TITLES.add("SpaceX");
        TITLES.add("СберТех");

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
        ACTIVITIES.add("Ракетостроение");
        ACTIVITIES.add("Наука");
        ACTIVITIES.add("Юмор");
        ACTIVITIES.add("Арт проект");
        ACTIVITIES.add("Автомойка");

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
        ADDRESSES.add("ул. Пушкина, 15");
        ADDRESSES.add("ул. Октябрьская, 20");
        ADDRESSES.add("ул. GrooveStreet, 0");
        ADDRESSES.add("ул. Телеграммная, 48");
        ADDRESSES.add("ул. Петренко, 96");

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
        TELEPHONES.add("1-101-101-10-10");
        TELEPHONES.add("1-121-121-12-12");
        TELEPHONES.add("6-485-758-42-63");
        TELEPHONES.add("8-469-136-75-96");
        TELEPHONES.add("6-693-125-49-96");

        NAMES.add("Антон");
        NAMES.add("Егор");
        NAMES.add("Маргарита");
        NAMES.add("Ольга");
        NAMES.add("Виктория");
        NAMES.add("Виктор");
        NAMES.add("Ксения");
        NAMES.add("Дарья");
        NAMES.add("Юрий");
        NAMES.add("Илья");
        NAMES.add("Анастасия");
        NAMES.add("Константин");
        NAMES.add("Владимир");
        NAMES.add("Ангелина");
        NAMES.add("Денис");

        SURNAMES.add("Нецкин");
        SURNAMES.add("Колыманов");
        SURNAMES.add("Самарина");
        SURNAMES.add("Хлопенкова");
        SURNAMES.add("Чернова");
        SURNAMES.add("Тришин");
        SURNAMES.add("Железняк");
        SURNAMES.add("Вдовина");
        SURNAMES.add("Бухаров");
        SURNAMES.add("Родионов");
        SURNAMES.add("Якушкина");
        SURNAMES.add("Аленцин");
        SURNAMES.add("Москаев");
        SURNAMES.add("Малынина");
        SURNAMES.add("Алексеев");

        PATRONYMICS.add("Петрович");
        PATRONYMICS.add("Дмитриевич");
        PATRONYMICS.add("Сергеевна");
        PATRONYMICS.add("Владимировна");
        PATRONYMICS.add("Алексеевна");
        PATRONYMICS.add("Витальевич");
        PATRONYMICS.add("Дмитриевна");
        PATRONYMICS.add("Александровна");
        PATRONYMICS.add("Александрович");
        PATRONYMICS.add("Андреевич");
        PATRONYMICS.add("Сергеевна");
        PATRONYMICS.add("Андреевич");
        PATRONYMICS.add("Олегович");
        PATRONYMICS.add("Владимировна");
        PATRONYMICS.add("Михайлович");

        QUALIFICATIONS.add(1);
        QUALIFICATIONS.add(2);
        QUALIFICATIONS.add(3);
        QUALIFICATIONS.add(4);
        QUALIFICATIONS.add(5);
        QUALIFICATIONS.add(6);
        QUALIFICATIONS.add(7);
        QUALIFICATIONS.add(1);
        QUALIFICATIONS.add(2);
        QUALIFICATIONS.add(3);
        QUALIFICATIONS.add(4);
        QUALIFICATIONS.add(5);
        QUALIFICATIONS.add(6);
        QUALIFICATIONS.add(7);
        QUALIFICATIONS.add(8);

        OTHER_INFO.add("Любит ОНЕМЕ");
        OTHER_INFO.add("Зависает в ВК");
        OTHER_INFO.add("Любит гулять");
        OTHER_INFO.add("Правша");
        OTHER_INFO.add("Левша");
        OTHER_INFO.add("Носит часы");
        OTHER_INFO.add("Плохое зрение");
        OTHER_INFO.add("ВЕГАН");
        OTHER_INFO.add("Любит пиццу");
        OTHER_INFO.add("Прогуливает пары");
        OTHER_INFO.add("Вышивает крестиком");
        OTHER_INFO.add("Меломан");
        OTHER_INFO.add("Холерик");
        OTHER_INFO.add("Флегматик");
        OTHER_INFO.add("Садовод");

        SALARIES.add(15652L);
        SALARIES.add(9652L);
        SALARIES.add(96856L);
        SALARIES.add(15486L);
        SALARIES.add(96254L);
        SALARIES.add(12365L);
        SALARIES.add(85632L);
        SALARIES.add(12546L);
        SALARIES.add(48693L);
        SALARIES.add(50000L);
        SALARIES.add(15698L);
        SALARIES.add(163549L);
        SALARIES.add(48963L);
        SALARIES.add(120000L);
        SALARIES.add(200000L);

        POSITIONS.add("Повар");
        POSITIONS.add("Руководитель");
        POSITIONS.add("Зам. директора");
        POSITIONS.add("Генеральный директор");
        POSITIONS.add("Уборщик");
        POSITIONS.add("Разработчик ПО");
        POSITIONS.add("Кассир");
        POSITIONS.add("Консультант");
        POSITIONS.add("Водитель");
        POSITIONS.add("Оператор Call-центра");
        POSITIONS.add("Администратор");
        POSITIONS.add("Менеджер");
        POSITIONS.add("Знакомый ген. дира");
        POSITIONS.add("Валятель дурака");
        POSITIONS.add("Тестировщик");

        COMMISSIONS.add(100L);
        COMMISSIONS.add(245L);
        COMMISSIONS.add(4565L);
        COMMISSIONS.add(4562L);
        COMMISSIONS.add(7586L);
        COMMISSIONS.add(4245L);
        COMMISSIONS.add(75473L);
        COMMISSIONS.add(45346L);
        COMMISSIONS.add(45312L);
        COMMISSIONS.add(50415L);
        COMMISSIONS.add(15698L);
        COMMISSIONS.add(149L);
        COMMISSIONS.add(483L);
        COMMISSIONS.add(120000L);
        COMMISSIONS.add(200L);


        //exclude names, surnames, patronymics
        shakeDataSets(TITLES, ACTIVITIES, ADDRESSES, TELEPHONES,
                QUALIFICATIONS, OTHER_INFO, SALARIES, COMMISSIONS, POSITIONS);

        checkDataSets(TITLES, ACTIVITIES, ADDRESSES, TELEPHONES,
                QUALIFICATIONS, OTHER_INFO, SALARIES, NAMES, SURNAMES, PATRONYMICS,
                COMMISSIONS, POSITIONS);
    }

    private static void shakeDataSets(List... lists) {
        Random random = new Random();

        for (List list : lists) {
            int count = list.size();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(count);
                list.set(randomIndex, list.set(i, list.get(randomIndex)));
            }
        }
    }

    private static void checkDataSets(List... lists) {
        for (List list : lists) {
            if (list.size() != DATASET_SIZE) {
                throw new RuntimeException("DATASETS IS INVALID!");
            }
        }
    }
}
