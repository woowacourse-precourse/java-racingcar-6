package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final static int MOVING_FORWARD = 4;
    private final static int FIRST_CAR_INDEX = 0;
    private final static int SECOND_CAR_INDEX = 1;

    public List<Car> toCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public void initCarsRandomNum(List<Car> carList) {
        for (Car car : carList) {
            car.initRandomNum();
        }
    }

    public void modifyForwardNum(List<Car> carList) {
        carList.stream()
                .filter(car -> isMove(car))
                .forEach(car -> car.increaseForwardNum());
    }

    private boolean isMove(Car car) {
        return car.getRandomNum() >= MOVING_FORWARD;
    }

    public List<String> findWinners(List<Car> carList) {
        List<String> winners = new ArrayList<>();
        int maxValue = findMaxValue(carList);

        carList.stream()
                .filter(car -> car.getForwardNum() == maxValue)
                .forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private int findMaxValue(List<Car> carList) {
        int maxValue = carList.get(FIRST_CAR_INDEX).getForwardNum();

        for (int i = SECOND_CAR_INDEX; i < carList.size(); i++) {
            if (maxValue < carList.get(i).getForwardNum()) {
                maxValue = carList.get(i).getForwardNum();
            }
        }

        return maxValue;
    }

}
