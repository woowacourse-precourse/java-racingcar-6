package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

import java.util.List;

public class RaceGameService {
    private static final int START_NUMBER = 1;
    private RaceCars raceCars;
    private final int attemptCount;
    private ExecutionView executionView;

    public RaceGameService(RaceCars raceCars, int attemptCount, ExecutionView executionView) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
        this.executionView = executionView;
    }

    public void run(){
        executionView.printExecutionStartMessage();
        List<Car> cars = raceCars.getCars();

        for (int attemptNumber = START_NUMBER; attemptNumber <= attemptCount; attemptNumber++) {
            raceCars.executeRace(randomValue());
            printGameProgressMessages(cars);
            executionView.newLine();
        }
    }

    private void printGameProgressMessages(List<Car> cars){
        cars.stream().forEach(executionView::printExecutionMessage);
    }

    private int randomValue(){
        return Randoms.getNumber();
    }

}
