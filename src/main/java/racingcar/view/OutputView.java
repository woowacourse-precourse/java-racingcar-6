package racingcar.view;

import java.util.List;
import racingcar.constant.message.GameMessage;
import racingcar.domain.Cars;
import racingcar.dto.ResultCars;

public class OutputView {

    private static final String LINE_BREAK = "\n";
    private final OutputFormatter outputFormatter;

    public OutputView() {
        this.outputFormatter = new OutputFormatter();
    }

    public void printStartMessage() {
        System.out.println(GameMessage.START_GAME);
    }

    public void printRepeatNumberMessage() {
        System.out.println(GameMessage.REPEAT_NUMBER_REQUEST);
    }

    public void printGameStatusMessage() {
        System.out.println(LINE_BREAK + GameMessage.EXECUTION_RESULT);
    }

    public void printGameStatus(final Cars cars) {
        List<String> carStatus = outputFormatter.getCarDistanceStatus(cars);

        for (String status : carStatus) {
            System.out.println(status);
        }

        System.out.println();
    }

    public void printRacingCarResult(final ResultCars resultCars) {
        System.out.print(GameMessage.FINAL_WINNER);
        String winnerCarName = outputFormatter.getWinner(resultCars);
        System.out.println(winnerCarName);
    }
}
