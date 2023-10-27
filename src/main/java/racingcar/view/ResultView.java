package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;
import racingcar.utils.InfoMessage;

import java.util.List;

public class ResultView {
    private static final String POSITION_STATUS = "-";
    private static final String NANE_COLON = ":";

    public ResultView() {
    }

    public void printShowResult() {
        System.out.println(InfoMessage.RESULT_MESSAGE.getMessage());
    }

    public void showRoundResult(List<Car> cars) {
        cars.forEach(car ->
            System.out.println(car.getName() + NANE_COLON + POSITION_STATUS.repeat(car.getPosition())));

        System.out.println();
    }

    public void callWinner(String winnerNames) {
        System.out.print(InfoMessage.CALL_WINNER_MESSAGE.getMessage());
        System.out.println(winnerNames);

    }
}
