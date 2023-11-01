package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Constants;
import racingcar.util.InputUtil;
import racingcar.util.OutputUtil;
import racingcar.util.RandomUtil;
import racingcar.view.RaceProgressView;

public class RaceService {

    private List<Car> carObjects = new ArrayList<>();
    private int lap = 0;

    public void start(String carName, String raceLap) {
        String[] carNameStrings = InputUtil.splitCarName(carName);
        for (String carNameStr : carNameStrings) {
            carObjects.add(new Car(carNameStr));
        }

        lap = InputUtil.getRaceLap(raceLap);
    }

    public String getProgress() {
        StringBuilder progress = new StringBuilder(Constants.NEW_LINE);

        for (int i = 0; i < lap; i++) {
            oneLap(carObjects);

            String currentProgress = OutputUtil.getCurrentProgress(carObjects);
            progress.append(currentProgress);
        }

        return progress.toString();
    }

    private void oneLap(List<Car> carObjects) {
        carObjects.stream().filter(car -> RandomUtil.moveForwardOrNot()).forEach(Car::moveForward);
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();

        int maxPosition = 0;
        for (Car car : carObjects) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        result.append(Constants.WINNER_PROMPT).append(Constants.SPACE).append(Constants.COLON_SEPARATOR);
        for (Car car : carObjects) {
            if (car.getPosition() == maxPosition) {
                result.append(Constants.SPACE).append(car.getName()).append(Constants.COMMA);
            }
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
