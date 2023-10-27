package racingcar;

import static java.lang.Math.max;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> carList;

    public void runGame() {
        this.carList = InputManager.inputCarList();
        int tryCnt = InputManager.inputTryCnt();

    }
}
