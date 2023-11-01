package racingcar.view;

import java.util.List;
import racingcar.domain.dto.CarDto;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_FORMAT = "%s : %s\n";
    private static final String POSITION_REGEX = "-";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public void printRaceStartMessage() {
        printEmptyLine();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<CarDto> racedCars) {
        racedCars.forEach(car -> printPositionOfEach(car));
        printEmptyLine();
    }

    private void printPositionOfEach(CarDto carDto) {
        System.out.format(POSITION_FORMAT, carDto.name(), POSITION_REGEX.repeat(Math.max(0, carDto.position())));
    }

    public void printWinners(List<String> winnerNames) {
        System.out.format(WINNER_MESSAGE_FORMAT, String.join(WINNER_NAME_DELIMITER, winnerNames));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
