package racingcar;

import java.util.List;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.racingCarOpeningComment();
        List<String> carNames = InputView.getCarNames();
        for (String carName : carNames) {
            System.out.println("carName = " + carName);
        }
    }
}
