package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class RacingCarGameController {
    private static List<String> racingCarNames;
    private static Integer countGame;
    private static final Integer RACING_CAR_NAME_LENGTH = 5;
    private static final String ERR_RACING_CAR_NAME_LENGTH = "길이 조건이 맞지 않습니다!";
    private static final String ERR_CONUT_OF_GAME_IS_NUMBER = "시도할 횟수 입력 시 숫자를 입력해주세요!";


    private RacingCarGameController() {
    }

    private static boolean isCollectLength(String name) {
        return name.length() <= RACING_CAR_NAME_LENGTH;
    }

    private static void validateRacingCarNames() {
        for (String str : racingCarNames) {
            if (!isCollectLength(str)) {
                throw new IllegalArgumentException(ERR_RACING_CAR_NAME_LENGTH);
            }
        }
    }

    public static void parseRacingCarNames(String str) {
        final String[] namesArray = str.split(",");

        racingCarNames = Arrays.asList(namesArray);
        validateRacingCarNames();
    }

    public static void parseCountGame(String str) {
        try {
            countGame = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_CONUT_OF_GAME_IS_NUMBER);
        }
    }

    public static void startGame() {
        String racingCarNamesString = InputView.enterRacingCarName();
        parseRacingCarNames(racingCarNamesString);

        String countGameString = InputView.enterCountGame();
        parseCountGame(countGameString);
    }
}
