package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.view.SystemMessage;

public class RacingGameController {

    RacingGameService racingGameService = new RacingGameService();

    SystemMessage systemMessage = new SystemMessage();

    public void playRacingGame() {
        systemMessage.printRequestInputMessage();
        String userCarNameInput = readLine();
        List<RacingCar> racingCars = racingGameService.carNameInput(userCarNameInput);

        systemMessage.printRequestTryCountMessage();
        String userTryCountInput = readLine();
        int round = racingGameService.racingRoundInput(userTryCountInput);

        for (int i = 0; i < round; i++) {
            racingGameService.race(racingCars);
        }

        systemMessage.printRacingResult(racingCars);
        systemMessage.printWinnerMessage(racingGameService.getWinner(racingCars));
    }
}
