package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {
    private static final String EMPTY_NAME_ERROR_MESSAGE = "이름으로 빈 문자열을 입력하여 오류가 발생하였습니다.";
    private static final String LONG_NAME_ERROR_MESSAGE = "5자 이하가 아닌 이름을 입력하여 오류가 발생하였습니다.";

    private List<RacingCar> racingCars;

    private RacingCars(final List<String> names) {
        validateNames(names);
        this.racingCars = new ArrayList<>();

        for (String name : names) {
            this.racingCars.add(RacingCar.createRacingCar(name));
        }
    }

    public static RacingCars createRacingCars(final String names) {
        return new RacingCars(splitNames(names));
    }

    private static List<String> splitNames(final String names) {
        return Arrays.asList(names.split(","));
    }

    private static void validateNames(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }

        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
            } else if (name.length() > 5) {
                throw new IllegalArgumentException(LONG_NAME_ERROR_MESSAGE);
            }
        }
    }

    public void tryMoveCars() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryMove();
        }
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();

        for (RacingCar racingCar : this.racingCars) {
            names.add(racingCar.getName());
        }

        return names;
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();

        for (RacingCar racingCar : this.racingCars) {
            positions.add(racingCar.getPosition());
        }

        return positions;
    }
}
