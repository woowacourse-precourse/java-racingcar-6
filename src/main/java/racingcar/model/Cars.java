package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_LAST_NUMBER = 9;
    private static final RandomUtils randomUtils = new RandomUtils();
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final List<Car> carList = new ArrayList<>();
    private static int maxPosition = 0;

    public void addCars(List<Car> inputCarList) {
        carList.addAll(inputCarList);
    }

    public StringBuilder singleRoundResult() {
        stringBuilder.setLength(0);
        for (Car car : carList) {
            stringBuilder.append("\n").append(singleCarResult(car));
        }
        return stringBuilder;
    }

    public List<String> getWinner() {
        List<String> winnerCarNames = new ArrayList<>();

        for (Car car : carList) {
            String carName = car.getCarNameAtMaxPosition(maxPosition);
            if (carName.length() > 0) {
                winnerCarNames.add(carName);
            }
        }

        return winnerCarNames;
    }

    private String singleCarResult(Car car) {
        int position = car.updateCar(randomUtils.getRandomNumber(RANDOM_START_NUMBER, RANDOM_LAST_NUMBER));
        updateMaxPosition(position);
        return car.getCurrentPosition();
    }

    private void updateMaxPosition(int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
    }
}
