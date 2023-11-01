package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Constant;

import java.util.List;

public class InputView {
    private static final String START_RACING_GAME_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CHECK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static int numberOfCars;
    private static int attemtsNumber;
    private static List<String> allUserCarName;
    public static void printStartMessage() {
        System.out.println(START_RACING_GAME_INPUT_CAR_NAME);
    }
    public static void printAttemptsNumber () {
        System.out.println(CHECK_NUMBER_OF_ATTEMPTS);
    }

    public static void checkInputRacingCarName () {
        String input = getInput();
        inputValidateCheck(input);
        printAttemptsNumber();
        diviedInputRacingCarName(input);
    }

    public static void inputValidateCheck(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        if(input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkAttemptsNumber () {
        String attemtsNumberStr = getInput();
        if(attemtsNumberStr.isEmpty()) {
            throw new IllegalArgumentException();
        }
        attemtsNumber = Integer.parseInt(attemtsNumberStr);
        return attemtsNumber;
    }

    public static void diviedInputRacingCarName (String input) {
        allUserCarName = List.of(input.split(","));
        numberOfCars = allUserCarName.size();
        for(int i = 0; i < numberOfCars; i++) {
            if(allUserCarName.get(i).length() > Constant.INPUT_LIMIT_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static List<String> getNameOfCars() {
        return allUserCarName;
    }
    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public static int getAttemptsNumber() {
        return attemtsNumber;
    }

    private static String getInput() {
        return Console.readLine();
    }
}
