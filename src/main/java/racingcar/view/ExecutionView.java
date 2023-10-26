package racingcar.view;

import racingcar.entity.car.Car;

import static racingcar.constants.MessageConstants.*;

public class ExecutionView {

    private static final String EXECUTION_MESSAGE_FORMAT = "%s : %s";

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
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<moveCount; i++){
            sb.append('-');
        }
        return sb.toString();
    }
}
