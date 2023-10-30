package racingcar.utils;

import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameOutput {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String MOVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String BEFORE_GAME_MESSAGE = "실행 결과";

    public static void printCarNameInputMessage(String message) {
        System.out.println(message);
    }

    public static void printMoveCountInputMessage(String message) {
        System.out.println(message);
    }
}
