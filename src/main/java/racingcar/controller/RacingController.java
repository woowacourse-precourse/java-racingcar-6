package racingcar.controller;

import racingcar.repository.CarRepository;
import racingcar.repository.ResultRepository;
import racingcar.service.RacingService;

public class RacingController {
    private RacingService racingService = new RacingService(CarRepository.getInstance(), ResultRepository.getInstance());

    public void run() {
        setGame();
        playGame();
        endGame();
    }

    private void endGame() {
        racingService.chooseWinner();
    }

    private void playGame() {
        racingService.play();
    }

    private void setGame() {
        racingService.initializeGame();
    }
}
