package racingcar.model;

import java.util.List;
import racingcar.view.RaceProgressView;

public class RaceService {

    public void startRace(List<Car> carObjects, int lap) {
        for (int i = 0; i < lap; i++) {
            oneLap(carObjects);
            List<String> carInfo = OutputUtil.printCarInfo(carObjects);
            RaceProgressView.printRaceProgress(carInfo);
        }
    }

    private void oneLap(List<Car> carObjects) {
        for (Car car : carObjects) {
            if (RandomUtil.moveForwardOrNot()) {
                car.moveForward();
            }
        }
    }
}
