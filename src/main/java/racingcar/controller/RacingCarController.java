package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView(new OutputView());
    }

    public void play() {
        List<String> racingCarNames = inputView.inputRacingCarNames();
        List<RacingCar> racingCars = createRacingCars(racingCarNames);

        // 게임 시작 로직
    }

    private List<RacingCar> createRacingCars(List<String> racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }
}
