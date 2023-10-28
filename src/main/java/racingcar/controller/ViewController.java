package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.StringUtils;

public class ViewController {

    public String[] createCar() {
        String carNames = carNameInput();
        return StringUtils.splitCarNames(carNames);
    }

    private String carNameInput() {
        String carList = Console.readLine();
        return carList;
    }
}
