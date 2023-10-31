package racingcar.controller;

import static racingcar.view.InputView.*;

public class Game {

    public void start() {
        String[] racingCar = askRacingCarName().split(",");
        int playNumber = askPlayNumber();
    }
}
