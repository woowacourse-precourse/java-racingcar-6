package racingcar.service;

import racingcar.entity.car.RaceCars;
import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

public class RaceGameService {
    private RaceCars raceCars;
    private final int attemptCount;

    public RaceGameService(RaceCars raceCars, int attemptCount) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
    }

    public void run(){
        ExecutionView.printExecutionStartMessage();

        for (int i=0; i<attemptCount; i++){
            raceCars.stream()
                    .forEach(car -> car.controlMovement(Randoms.getNumber()));

            raceCars.stream()
                    .forEach(ExecutionView::printExecutionMessage);

            ExecutionView.newLine();
        }
        System.out.println("최종 우승자 : " + raceCars.victoryCarName());
    }
}
