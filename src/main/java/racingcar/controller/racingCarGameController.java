package racingcar.controller;


import racingcar.domain.racingCars;
import racingcar.view.inputView;

public class racingCarGameController {
    public static void play() {
        racingCars racingCars = new racingCars(inputView.requireRacingCarName());

    }
}
