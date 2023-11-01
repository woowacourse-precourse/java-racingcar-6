package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.util.Constants;
import racingcar.util.InputUtil;
import racingcar.util.OutputUtil;
import racingcar.util.RandomUtil;

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

        IntStream.range(0, lap).forEach(i -> {
            oneLap(carObjects);
            String currentProgress = OutputUtil.getCurrentProgress(carObjects);
            progress.append(currentProgress);
        });

        return progress.toString();
    }

    public String getResult() {
        int maxPosition = getMaxPosition();

        return getResultString(maxPosition);
    }

    private void oneLap(List<Car> carObjects) {
        carObjects.stream().filter(car -> RandomUtil.moveForwardOrNot()).forEach(Car::moveForward);
    }

    private String getResultString(int maxPosition) {
        StringBuilder result = new StringBuilder();

        result.append(Constants.WINNER_PROMPT).append(Constants.SPACE).append(Constants.COLON_SEPARATOR);
        getWinner(maxPosition, result);

        return result.toString();
    }

    private void getWinner(int maxPosition, StringBuilder result) {
        for (Car car : carObjects) {
            if (isWinner(maxPosition, car)) {
                result.append(Constants.SPACE).append(car.getName()).append(Constants.COMMA);
            }
        }
        deleteLastSeparator(result);
    }

    private static void deleteLastSeparator(StringBuilder result) {
        result.deleteCharAt(result.length() - 1);
    }

    private static boolean isWinner(int maxPosition, Car car) {
        return car.getPosition() == maxPosition;
    }

    private int getMaxPosition() {
        return getPositionStream().max().orElse(0);
    }

    private IntStream getPositionStream() {
        return carObjects.stream().mapToInt(Car::getPosition);
    }
}
