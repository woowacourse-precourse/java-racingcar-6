package racingcar.view;

import racingcar.domain.car.Car;

import static racingcar.constants.MessageConstants.*;

public class ExecutionView {

    private static final String EXECUTION_MESSAGE_FORMAT = "%s : %s";
    private static final String HYPHEN = "-";

    public void printExecutionStartMessage(){
        System.out.println(EXECUTION_START_MESSAGE);
    }

    public void printExecutionMessage(Car car) {
        System.out.println(getExecutionMessage(car.getName(), car.getMoveCount()));
    }

    private String getExecutionMessage(String name, int moveCount) {
        String hyphenString = generateHyphenString(moveCount);
        return String.format(EXECUTION_MESSAGE_FORMAT, name, hyphenString);
    }

    private String generateHyphenString(int moveCount) {
        return HYPHEN.repeat(moveCount);
    }

    public void newLine() {
        System.out.println();
    }

}
