package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_EXPRESSION_SYMBOL = "-";

    public void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

    private void newLine() {
        System.out.println();
    }

    public void printRaceResult(List<CarDto> cars) {
        cars.forEach(car -> System.out.println(generateMessageOf(car)));
    }

    private String generateMessageOf(CarDto car) {
        return String.format("%s : %s", car.name(), generatePositionMessage(car.position()));
    }

    private String generatePositionMessage(int position) {
        return POSITION_EXPRESSION_SYMBOL.repeat(position);
    }
}
