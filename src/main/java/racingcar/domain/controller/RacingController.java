package racingcar.domain.controller;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.view.inputer.ChallengeInputer;
import racingcar.domain.view.printer.WinnerPrinter;
import racingcar.domain.util.referee.InGameReferee;
import racingcar.domain.service.RacingService;
import racingcar.domain.entity.valueobject.Challenge;

public class RacingController {
    public void startRacing() {
        RacingService racingService = new RacingService();
        List<Car> cars = racingService.getCars();
        Challenge challenge = ChallengeInputer.getChallenge();

        for (int i = 0; i < challenge.getNumber(); i++) {
            racingService.getResult(cars);
        }

        List<Car> winners = InGameReferee.findWinner(cars);
        WinnerPrinter.printWinner(winners);
    }
}
