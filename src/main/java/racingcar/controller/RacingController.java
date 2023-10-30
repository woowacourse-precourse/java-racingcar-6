package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {


    public void startRace() {
        generateRacersFromNames(InputView.readCarNames());
    }

    public String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
