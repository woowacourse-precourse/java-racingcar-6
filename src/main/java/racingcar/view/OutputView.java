package racingcar.view;

import racingcar.domain.CarGarage;
import racingcar.domain.Winner;
import racingcar.util.StringFormatter;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    private final StringFormatter stringFormatter;

    public OutputView(StringFormatter stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRaceResult(CarGarage cars) {
        String result = stringFormatter.makeRaceResult(cars);
        System.out.println(result);
    }

    public void printWinner(Winner winner) {
        String result = stringFormatter.makeWinnerResult(winner);
        System.out.println(result);
    }
}
