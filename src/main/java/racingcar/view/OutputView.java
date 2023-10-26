package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.StringUtil;

import java.util.List;

public class OutputView {

    private final StringUtil stringUtil;

    public OutputView(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String result = stringUtil.makeRaceResult(car);
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinner(List<Car> winner) {
        String result = stringUtil.makeWinnerResult(winner);
        System.out.println(result);
    }
}
