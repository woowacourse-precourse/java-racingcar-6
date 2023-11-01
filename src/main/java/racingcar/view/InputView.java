package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String START_RACING_GAME_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CHECK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static int numberOfCars;

    public static void printStartMessage() {
        System.out.println(START_RACING_GAME_INPUT_CAR_NAME);
    }

    public static void printAttemptsNumber () {
        System.out.println(CHECK_NUMBER_OF_ATTEMPTS);
    }

    public static void checkInputRacingCarName () {
        String input = getInput();
        printAttemptsNumber();
        diviedInputRacingCarName(input);
    }


    public static int checkAttemptsNumber () {
        String attemtsNumberStr = getInput();
        int attemtsNumber = Integer.parseInt(attemtsNumberStr);
        return attemtsNumber;
    }

    public static void diviedInputRacingCarName (String input) {
        List<String> allUserCarName = List.of(input.split(","));
        numberOfCars = allUserCarName.size();
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    private static String getInput() {
        return Console.readLine();
    }
}
