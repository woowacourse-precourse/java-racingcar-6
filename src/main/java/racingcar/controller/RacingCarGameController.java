package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class RacingCarGameController {
    private static List<String> racingCarNames;
    private static final Integer RACING_CAR_NAME_LENGTH = 5;

    private RacingCarGameController() {
    }

    private static boolean isCollectLength(String name) {
        return name.length() <= RACING_CAR_NAME_LENGTH;
    }

    private static void validateRacingCarNames() {
        for (String str : racingCarNames) {
            if (!isCollectLength(str)) {
                throw new IllegalArgumentException("길이 조건이 맞지 않습니다!");
            }
        }
    }

    private static void parseRacingCarNames(String str) {
        final String[] namesArray = str.split(",");

        racingCarNames = Arrays.asList(namesArray);
        validateRacingCarNames();
    }

    public static void startGame() {
        String racingCarNamesString = InputView.enterRacingCarName();

        parseRacingCarNames(racingCarNamesString);
    }
}
