package racingcar.service;

import racingcar.domain.car.RaceCars;
import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

public class RaceGameService {
    private static final int START_NUMBER = 1;
    private RaceCars raceCars;
    private final int attemptCount;

    public RaceGameService(RaceCars raceCars, int attemptCount) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
    }

    public void run(){
        ExecutionView.printExecutionStartMessage();

        for (int attemptNumber = START_NUMBER; attemptNumber <= attemptCount; attemptNumber++) {
            raceCars.executeRace(Randoms.getNumber());
            raceCars.printGameProgressMessages();
            ExecutionView.newLine();
        }
    }
}
