package racingcar;

import java.util.List;

public class ConsolePrint {
    public void requestCarNameInput() {
        System.out.println(Message.CAR_NAME_REQUEST.getValue());
    }

    public void requestTryCountInput() {
        System.out.println(Message.TRY_COUNT_REQUEST.getValue());
    }
    public void informRacingResult() {
        System.out.println(Message.RESULT_RACING_INFO.getValue());
    }

    public void racingTryResult(Car name, CarStatus status) {
        StringBuilder moveTrace = new StringBuilder();
        moveTrace.append(name).append(" : ");
        if (status.equals(CarStatus.MOVE)) {
            moveTrace.append("-");
        }
        System.out.println(moveTrace.toString());
    }

    public void finalWinner(List<Car> winners) {
        StringBuilder winnerString = new StringBuilder();
        System.out.println(Message.FINAL_WINNER_INFO.getValue());
        for (Car winner : winners) {
            winnerString.append(winner.getName()).append(Message.DELIMITER_PRINT_CARS.getValue());
        }
    }
}
