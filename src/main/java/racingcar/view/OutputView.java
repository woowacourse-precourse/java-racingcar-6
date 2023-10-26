package racingcar.view;

import racingcar.domain.CarGarage;
import racingcar.domain.Winner;
import racingcar.util.StringUtil;

public class OutputView {

    private final StringUtil stringUtil;

    public OutputView(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(CarGarage cars) {
        String result = stringUtil.makeRaceResult(cars);
        System.out.println(result);
    }

    public void printWinner(Winner winner) {
        String result = stringUtil.makeWinnerResult(winner);
        System.out.println(result);
    }
}
