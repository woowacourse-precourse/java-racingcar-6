package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();
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
        System.out.println(generateRaceResultMessage(cars));
        newLine();
    }

    private String generateRaceResultMessage(List<CarDto> cars) {
        return cars.stream()
                .map(this::generateMessageOf)
                .collect(Collectors.joining(NEWLINE));
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
