package racingcar.io.output;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.judge.WinnerCars;
import racingcar.global.CharacterSymbol;

public class ConsoleWriter {

    private static final String MOVE_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_RESULT_FORMAT = "최종 우승자 : %s";

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

    public void printWinnerResult(WinnerCars winnerCars) {
        printLine(toWinnerResultFormat(winnerCars));
    }

    private String toWinnerResultFormat(WinnerCars winnerCars) {
        List<Car> cars = winnerCars.getCars();

        if (cars.size() == 1) {
            Car uniqueWinner = cars.get(0);
            return WINNER_RESULT_FORMAT.formatted(uniqueWinner.getName());
        }

        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        return WINNER_RESULT_FORMAT.formatted(String.join(", ", carNames));
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

    private void printLine(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
