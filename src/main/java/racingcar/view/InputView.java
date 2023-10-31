package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String START_RACING_GAME_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CHECK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    public static void printStartMessage() {
        System.out.println(START_RACING_GAME_INPUT_CAR_NAME);
    }

    public static void printAttemptsNumber () {
        System.out.println(CHECK_NUMBER_OF_ATTEMPTS);
    }

    public static String checkInputRacingCarName () {
        String input = getInput();
        return input;
    }

    public static List<String> diviedInputRacingCarName(String input) {
        List<String> allUserCarName = List.of(input.split(","));
        return allUserCarName;
    }

    private static String getInput() {
        return Console.readLine();
    }
}
