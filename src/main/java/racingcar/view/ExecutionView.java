package racingcar.view;

import racingcar.entity.car.Car;

import static racingcar.constants.MessageConstants.*;

public class ExecutionView {

    private static final String EXECUTION_MESSAGE_FORMAT = "%s : %s";
    private static final String WINNING_CAR_NAMES_MESSAGE = "최종 우승자 : %s";
    private static final String HYPHEN = "-";

    public static void printWinningCarNames(String carNames){
        System.out.println(String.format(WINNING_CAR_NAMES_MESSAGE, carNames));
    }

    public static void printExecutionStartMessage(){
        System.out.println(EXECUTION_START_MESSAGE);
    }

    public static void printExecutionMessage(Car car) {
        System.out.println(getExecutionMessage(car.getName(), car.getMoveCount()));
    }

    private static String getExecutionMessage(String name, int moveCount){
        String hyphenString = generateHyphenString(moveCount);
        return String.format(EXECUTION_MESSAGE_FORMAT, name, hyphenString);
    }

    private static String generateHyphenString(int moveCount){
        return HYPHEN.repeat(moveCount);
    }

    public static void newLine(){
        System.out.println();
    }
}
