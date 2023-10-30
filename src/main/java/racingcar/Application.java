package racingcar;

import racingcar.domain.RacingCarApplication;
import racingcar.presentation.CarViewer;

public class Application {
    public static void main(String[] args) {
        CarViewer carViewer = CarViewer.getInstance();

        RacingCarApplication racingCarApplication = new RacingCarApplication(carViewer);
        racingCarApplication.run();
    }
}
