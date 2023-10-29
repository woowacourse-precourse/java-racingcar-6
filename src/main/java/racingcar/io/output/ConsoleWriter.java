package racingcar.io.output;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.global.CharacterSymbol;

public class ConsoleWriter {

    private static final String MOVE_RESULT_FORMAT = "%s : %s";

    public void printCarNameInputGuide() {
        printLine(OutputMessage.CAR_NAME_INPUT_GUIDE.getLiteral());
    }

    public void printMovingCountInputGuide() {
        printLine(OutputMessage.MOVING_COUNT_INPUT_GUIDE.getLiteral());
    }

    public void printExecutionResultMessage() {
        printEmptyLine();
        printLine(OutputMessage.EXECUTION_RESULT.getLiteral());
    }

    public void printMoveResult(Cars cars) {
        cars.getCars().forEach(car -> printLine(toMoveResultFormat(car)));
        printEmptyLine();
    }

    private void printLine(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private String toMoveResultFormat(Car car) {
        return MOVE_RESULT_FORMAT.formatted(car.getName(), toForwardCountOutputFormat(car.getForwardCount()));
    }

    private String toForwardCountOutputFormat(long count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            stringBuilder.append(CharacterSymbol.HYPHEN.getLiteral());
        }

        return stringBuilder.toString();
    }

}
