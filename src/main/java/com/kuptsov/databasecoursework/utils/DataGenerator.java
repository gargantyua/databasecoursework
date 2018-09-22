package com.kuptsov.databasecoursework.utils;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Deal;
import com.kuptsov.databasecoursework.model.Emploer;

import java.util.*;

public class DataGenerator {

    private final static List<Integer> UNIQUE_RANDOM_GENERATED_BUFFER =
            new ArrayList<>(GeneratorStaticStorage.DATASET_SIZE);

    static {
        Random random = new Random();

        do {
            int i = random.nextInt(GeneratorStaticStorage.DATASET_SIZE);

            if (!UNIQUE_RANDOM_GENERATED_BUFFER.contains(i)) {
                UNIQUE_RANDOM_GENERATED_BUFFER.add(i);
            }

        } while (UNIQUE_RANDOM_GENERATED_BUFFER.size() != GeneratorStaticStorage.DATASET_SIZE);
    }

    private DataGenerator() {}

    public static List<Emploer> generateEmploers() {

        List<Emploer> result = new ArrayList<>();

        UNIQUE_RANDOM_GENERATED_BUFFER.forEach(index -> result.add(
                Emploer.builder()
                        .title(GeneratorStaticStorage.TITLES.get(index))
                        .activity(GeneratorStaticStorage.ACTIVITIES.get(index))
                        .address(GeneratorStaticStorage.ADDRESSES.get(index))
                        .telephone(GeneratorStaticStorage.TELEPHONES.get(index))
                        .build()
        ));

        return result;
    }

    public static List<Applicant> generateApplicants() {

        List<Applicant> result = new ArrayList<>();

        UNIQUE_RANDOM_GENERATED_BUFFER.forEach(index -> result.add(
                Applicant.builder()
                        .name(GeneratorStaticStorage.NAMES.get(index))
                        .surname(GeneratorStaticStorage.SURNAMES.get(index))
                        .patronymic(GeneratorStaticStorage.PATRONYMICS.get(index))
                        .qualification(GeneratorStaticStorage.QUALIFICATIONS.get(index))
                        .activity(GeneratorStaticStorage.ACTIVITIES.get(index))
                        .otherInfo(GeneratorStaticStorage.OTHER_INFO.get(index))
                        .salary(GeneratorStaticStorage.SALARIES.get(index))
                        .build()
        ));

        return result;
    }

    public static List<Deal> generateDeals(Iterable<Applicant> applicants, Iterable<Emploer> emploers) {

        List<Deal> result = new ArrayList<>();

        emploers.forEach(emploer -> applicants.forEach(applicant -> {
            if (emploer.getActivity().equals(applicant.getActivity())) {
                result.add(
                        Deal.builder()
                                .applicant(applicant)
                                .emploer(emploer)
                                .build()
                );
            }
        }));

        result.forEach(deal -> {
            deal.setPosition(GeneratorStaticStorage.POSITIONS.get(result.indexOf(deal)));
            deal.setCommission(GeneratorStaticStorage.COMMISSIONS.get(result.indexOf(deal)));
        });

        return result;
    }
}
