package racingcar.domain.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.inputer.ChallengeInputer;
import racingcar.domain.referee.InGameReferee;
import racingcar.domain.service.RacingService;
import racingcar.domain.valueobject.Challenge;

public class RacingController {
    public void startRacing() {
        RacingService racingService = new RacingService();
        List<Car> cars = racingService.getCars();
        Challenge challenge = ChallengeInputer.getChallenge();

        for (int i = 0; i < challenge.getNumber(); i++) {
            racingService.getResult(cars);
        }

        List<Car> winners = InGameReferee.findWinner(cars);
        // TODO: 2023-10-30 최종 우승자 출력
    }
}
