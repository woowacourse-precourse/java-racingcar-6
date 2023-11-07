package racingcar.domain.controller;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.view.inputer.ChallengeInputer;
import racingcar.domain.view.printer.WinnerPrinter;
import racingcar.domain.util.referee.InGameReferee;
import racingcar.domain.service.RacingService;
import racingcar.domain.entity.valueobject.Challenge;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void startRacing() {
        List<Car> cars = racingService.getCars();
        Challenge challenge = ChallengeInputer.getChallenge();

        challengeRace(racingService, cars, challenge);

        List<Car> winners = InGameReferee.findWinner(cars);
        WinnerPrinter.printWinner(winners);
    }

    private static void challengeRace(RacingService racingService, List<Car> cars, Challenge challenge) {
        for (int i = 0; i < challenge.getNumber(); i++) {
            racingService.getResult(cars);
        }
    }
}
