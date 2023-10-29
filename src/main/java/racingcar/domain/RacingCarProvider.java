package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarProvider {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validate(String[] names) {
        for (String name : names) {
            if (!isValidLength(name)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private boolean isValidLength(String name) {
        return name.length() <= MAX_CAR_NAME_LENGTH;
    }

    public List<RacingCar> createRacingCars(String[] names) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String name : names) {
            RacingCar racingCar = RacingCar.create(name);
            racingCars.add(racingCar);
        }

        return racingCars;
    }
}
