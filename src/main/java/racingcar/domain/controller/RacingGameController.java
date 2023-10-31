package racingcar.domain.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingGameService;

public class RacingGameController {

    RacingGameService racingGameService = new RacingGameService();

    public void playRacingGame() {
        List<RacingCar> racingCars = racingGameService.carNameInput();
        int round = racingGameService.racingRoundInput();

        for (int i = 0; i < round; i++) {
            racingGameService.race(racingCars);
        }

        List<String> winner = racingGameService.getWinner(racingCars);
    }
}
