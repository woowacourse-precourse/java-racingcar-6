package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MAX_FORWARD = -1;
    private static final int FORWARD_NUMBER = 4;
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void updateForwardCar() {
        for (Car car : carList) {
            if (isForward(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))) {
                car.moveForward();
            }
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinnerCarNameList() {
        int maxForward = findMaxForward();
        return findWinnerCarNames(maxForward);
    }

    private int findMaxForward() {
        return carList.stream()
                .mapToInt(Car::getForward)
                .max()
                .orElse(MAX_FORWARD);
    }

    private List<String> findWinnerCarNames(int maxForward) {
        return carList.stream()
                .filter(car -> car.getForward() == maxForward)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= FORWARD_NUMBER;
    }
}
