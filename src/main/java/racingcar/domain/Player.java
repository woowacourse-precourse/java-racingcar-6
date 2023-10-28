package racingcar.domain;

import java.util.Arrays;

public class Player {

    private static final String CAR_NAME_SEPARATOR = ",";

    private final String namesOfCars;

    public Player(String namesOfCars) {
        this.namesOfCars = namesOfCars;
    }

    public String[] splitNamesOfCars() {
        return namesOfCars.split(CAR_NAME_SEPARATOR);
    }

    public void validateDuplicationName(String[] namesOfCars) {
        int count = (int) Arrays.stream(namesOfCars)
                .distinct()
                .count();

        if (count != namesOfCars.length) {
            throw new IllegalArgumentException("중복");
        }
    }
}
