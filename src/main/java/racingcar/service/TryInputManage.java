package racingcar.service;

import racingcar.util.InputManufacture;
import racingcar.view.InputView;

public class TryInputManage {
    private final InputManufacture manufacture = new InputManufacture();

    public int makeTryNumber(InputView input) {
        String attempt = input.readTryNumber();
        return manufacture.changeIntegerNumber(attempt);
    }
}
