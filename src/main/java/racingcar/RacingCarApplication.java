package racingcar;

import java.util.List;

public class RacingCarApplication {
    private final CarViewer carViewer;

    public RacingCarApplication(CarViewer carViewer) {
        this.carViewer = carViewer;
    }

    public void run() {

        List<String> carNames = carViewer.inputCarNames();
        Cars cars = Cars.of(carNames);

        int attemptCount = carViewer.inputAttemptCount();


        carViewer.outputExecute();

        cars.goForward(attemptCount);


        carViewer.outputWinner(cars.getWinningCarNames());

        System.out.println();
    }
}
