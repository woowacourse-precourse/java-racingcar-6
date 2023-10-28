package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.TryCount;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;

public class ViewController {

    public static String[] InputCarName() {
        String carNames = InputView.inputCarNames();
        return StringUtils.splitCarNames(carNames);
    }

    public static int InputTryCount() {
        TryCount tryCount = new TryCount(InputView.inputTryCount());
        return tryCount.getTryCount();
    }

    public static String resultPosition(Car car) {
        StringBuilder resultPosition = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            resultPosition.append("-");
        }

        return resultPosition.toString();
    }
}
