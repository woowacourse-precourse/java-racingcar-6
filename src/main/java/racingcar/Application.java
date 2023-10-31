package racingcar;

import java.util.List;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();
        System.out.println(carNames);
        System.out.println(tryCount);
    }
}
