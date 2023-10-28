package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.StringUtils;

public class ViewController {

    public String[] createCar() {
        String carNames = InputCarName();
        return StringUtils.splitCarNames(carNames);
    }

    private String InputCarName() {
        String carList = Console.readLine();
        return carList;
    }
}
