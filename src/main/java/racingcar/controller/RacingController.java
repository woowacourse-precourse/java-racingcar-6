package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingStadium;
import racingcar.view.RacingView;

public class RacingController {
    private final RacingStadium racingStadium;
    private final RacingView racingView = new RacingView();

    public RacingController() {
        List<Car> participants = new ArrayList<>();
        for (String carName : racingView.getCarNames()) {
            participants.add(new Car(carName));
        }

        racingStadium = new RacingStadium(participants);
    }

    public void startRace() {
        int trials = racingView.getTrials();
        racingView.printRacingResult();
        for (int i = 0; i < trials; i++) {
            racingStadium.doRace();
            racingView.printEachTrialResult(racingStadium.getCars());
        }
        racingView.printWinners(racingStadium.getWinners());
    }
}
