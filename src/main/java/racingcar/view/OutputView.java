package racingcar.view;

import racingcar.controller.dto.response.GameResultDto;
import racingcar.controller.dto.response.RaceResultDto;
import racingcar.model.Car;

public class OutputView {
    public static final String OUTPUT_EXECUTION_RESULT_MESSAGE = "실행 결과";
    public static final String OUTPUT_FINAL_RESULT_MESSAGE = "최종 우승자 : ";
    public static final String PROGRESS_SYMBOL = "-";
    public static final String NEW_LINE_SYMBOL = "\n";

    public void printExecutionResultMessage() {
        showMessage(NEW_LINE_SYMBOL);
        showMessage(OUTPUT_EXECUTION_RESULT_MESSAGE);
        showMessage(NEW_LINE_SYMBOL);
    }

    public void printRaceResult(RaceResultDto raceResultDto) {
        for (Car car : raceResultDto.carList()) {
            showCarStatus(car);
        }
        showMessage(NEW_LINE_SYMBOL);
    }

    private void showCarStatus(Car car) {
        System.out.printf("%s : %s\n", car.getName(), PROGRESS_SYMBOL.repeat(car.getPosition()));
    }

    public void printGameResult(GameResultDto gameResultDto) {
        showMessage(OUTPUT_FINAL_RESULT_MESSAGE);

        String result = String.join(", ", gameResultDto.winnerNameList());
        showMessage(result);
    }

    private void showMessage(String message) {
        System.out.print(message);
    }
}
