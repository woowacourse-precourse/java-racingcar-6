package racingcar.view;

import racingcar.domain.Car;
import racingcar.utils.InfoMessage;

public class ResultView {
    private static final String POSITION_SYMBOL = "-";
    private static final String NANE_POSITION_SPLITTER = ":";

    private ResultView() {
    }

    public void printShowResult() {
        System.out.println(InfoMessage.RESULT_MESSAGE.getMessage());
    }

    public void showRoundResult(Car car) {
        System.out.print(car.getName() + NANE_POSITION_SPLITTER);
        showPosition(car.getPosition());
    }

    public void showPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_SYMBOL);
        }
    }
}
