package racingcar.controller;

import racingcar.model.CarNameRepository;

public class RacingGameController {

    private CarNameRepository carNameRepository;

    public RacingGameController() {
        this.carNameRepository = new CarNameRepository();
    }

    public void setCarName(String carName) {
        // validation & save car name
        carNameRepository.saveCarNames(carName);
    }

    public void setAttempts(String attempts) {
        // validation
        // save attempts
    }

    public void startGame() {

    }
}
