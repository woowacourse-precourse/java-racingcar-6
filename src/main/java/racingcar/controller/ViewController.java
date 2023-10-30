package racingcar.controller;

import racingcar.domain.TryCount;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;

import java.util.List;

public class ViewController {

    public static List<String> setCars() {
        String carNamesInput = InputView.inputCarNames();
        return StringUtils.splitCarNames(carNamesInput);
    }

    public static int setTryCount() {
        TryCount tryCount = new TryCount(InputView.inputTryCount());
        return tryCount.getTryCount();
    }

}
