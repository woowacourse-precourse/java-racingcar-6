package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {
    private static final String EMPTY_NAME_ERROR_MESSAGE = "이름으로 빈 문자열을 입력하여 오류가 발생하였습니다.";
    private static final String LONG_NAME_ERROR_MESSAGE = "5자 이하가 아닌 이름을 입력하여 오류가 발생하였습니다.";

    private List<RacingCar> racingCars;

    private RacingCars(final List<String> names) {
        this.racingCars = new ArrayList<>();

        for (String name : names) {
            this.racingCars.add(RacingCar.createRacingCar(name));
        }
    }

    public static RacingCars createRacingCars(final String names) {
        return new RacingCars(validateAndSplitNames(names));
    }

    private static List<String> validateAndSplitNames(final String names) {
        hasEmptyName(names);
        List<String> namesSplit = splitNames(names);
        hasLongName(namesSplit);
        return namesSplit;
    }

    private static List<String> splitNames(final String names) {
        return Arrays.asList(names.split(","));
    }

    private static void hasEmptyName(final String names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        } else if (names.charAt(0) == ',') {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        } else if (names.charAt(names.length() - 1) == ',') {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }

        for (int i = 1; i < names.length(); i++) {
            if (names.charAt(i - 1) == ',' && names.charAt(i) == ',') {
                throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
            }
        }
    }

    private static void hasLongName(final List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(LONG_NAME_ERROR_MESSAGE);
            }
        }
    }

    public void tryMoveCars() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryMove();
        }
    }

    public List<String> getResultsMoving() {
        List<String> results = new ArrayList<>();

        for (RacingCar racingCar : this.racingCars) {
            results.add(racingCar.getResultMoving());
        }

        return results;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (RacingCar racingCar : this.racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (RacingCar racingCar : this.racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }

        return maxPosition;
    }
}
