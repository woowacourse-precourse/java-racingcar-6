package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자";

    private static final String MESSAGE_FORMAT = "%s : %s";
    private static final String POSITION_EXPRESSION_SYMBOL = "-";
    private static final String NAME_DELIMITER = ", ";

    public void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

    private void newLine() {
        System.out.println();
    }

    public void printRaceResult(List<CarDto> cars) {
        cars.forEach(car -> System.out.println(generateMessageOf(car)));
        newLine();
    }

    private String generateMessageOf(CarDto car) {
        return String.format(MESSAGE_FORMAT, car.name(), generatePositionMessage(car.position()));
    }

    private String generatePositionMessage(int position) {
        return POSITION_EXPRESSION_SYMBOL.repeat(position);
    }

    public void printWinners(List<String> winners) {
        System.out.printf(MESSAGE_FORMAT, WINNERS_MESSAGE, String.join(NAME_DELIMITER, winners));
    }
}
