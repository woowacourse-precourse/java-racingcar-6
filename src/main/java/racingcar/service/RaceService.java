package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.OutputUtil;
import racingcar.util.RandomUtil;
import racingcar.view.RaceProgressView;

public class RaceService {

    public String startRace(List<Car> carObjects, int lap) {
        for (int i = 0; i < lap; i++) {
            oneLap(carObjects);
            List<String> carInfo = OutputUtil.printCarInfo(carObjects);
            RaceProgressView.printRaceProgress(carInfo);
        }

        return getResult(carObjects);
    }

    private void oneLap(List<Car> carObjects) {
        for (Car car : carObjects) {
            if (RandomUtil.moveForwardOrNot()) {
                car.moveForward();
            }
        }
    }

    private String getResult(List<Car> carObjects) {
        StringBuilder result = new StringBuilder();

        int maxPosition = 0;
        for (Car car : carObjects) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        result.append("최종 우승자 :");
        for (Car car : carObjects) {
            if (car.getPosition() == maxPosition) {
                result.append(" ").append(car.getName()).append(",");
            }
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
