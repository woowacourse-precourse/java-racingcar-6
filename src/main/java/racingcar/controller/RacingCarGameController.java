package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;

public class RacingCarGameController {
    /** Main properties */
    private static List<String> racingCarNames;
    private static Integer countGame;
    private static final List<RacingCar> racingCars = new ArrayList<>();

    /** Contant properties */
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

    public static void generateRacingCars() {
        for (String name : racingCarNames) {
            RacingCar car = new RacingCar(name);
            racingCars.add(car);
        }
    }

    public static void startGame() {
        String racingCarNamesString = InputView.enterRacingCarName();
        parseRacingCarNames(racingCarNamesString);

        String countGameString = InputView.enterCountGame();
        parseCountGame(countGameString);

        generateRacingCars();

        // 자동차 생성
        // 주어진 반복 횟수만큼 반복하며
            // 생성한 자동차 마다 반복하여
                // 랜덤 숫자 생성
                // 숫자 판단하기
                // 전진 또는 정지
    }
}
