package racingcar.view;

import racingcar.controller.dto.response.RaceResultDto;
import racingcar.model.Car;

public class OutputView {
    public static final String OUTPUT_EXECUTION_RESULT_MESSAGE = "실행 결과";
    public static final String PROGRESS_SYMBOL = "-";

    public void printExecutionResultMessage() {
        System.out.println(OUTPUT_EXECUTION_RESULT_MESSAGE);
    }

    public void printRaceResult(RaceResultDto raceResultDto) {
        for (Car car : raceResultDto.carList()) {
            printCarStatus(car);
        }
        printEmptyLine();
    }

    private void printCarStatus(Car car) {
        System.out.printf("%s : %s\n", car.getName(), PROGRESS_SYMBOL.repeat(car.getPosition()));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
