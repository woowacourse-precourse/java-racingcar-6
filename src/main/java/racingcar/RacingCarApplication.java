package racingcar;

import java.util.List;
import java.util.Map;

public class RacingCarApplication {
    private final CarViewer carViewer;

    public RacingCarApplication(CarViewer carViewer) {
        this.carViewer = carViewer;
    }

    public void run() {

        List<String> carNames = carViewer.inputCarNames();
        Cars cars = Cars.createByNames(carNames);

        int attemptCount = carViewer.inputAttemptCount();


        carViewer.outputExecute();

        for (int i = 0; i < attemptCount; i++) {
            Map<String, Integer> status = cars.goForward();

            carViewer.outputStatus(status);
        }




        carViewer.outputWinner(cars.getWinningCarNames());

        System.out.println();
    }
}
