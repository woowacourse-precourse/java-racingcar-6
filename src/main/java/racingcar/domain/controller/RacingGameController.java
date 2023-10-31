package racingcar.domain.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.view.SystemMessage;

public class RacingGameController {

    RacingGameService racingGameService = new RacingGameService();

    SystemMessage systemMessage = new SystemMessage();
    public void playRacingGame() {
        List<RacingCar> racingCars = racingGameService.carNameInput();
        int round = racingGameService.racingRoundInput();

        for (int i = 0; i < round; i++) {
            racingGameService.race(racingCars);
        }

        systemMessage.printRacingResult(racingCars);
        systemMessage.printWinnerMessage(racingGameService.getWinner(racingCars));
    }
}
