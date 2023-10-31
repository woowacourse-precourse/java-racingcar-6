package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class CarList {

    private final List<Car> carList;
    private static final int MOVE = 4;

    public CarList(List<String> carNameList) {
        carList = carNameList.stream().map(Car::new).toList();
    }

    public void race() {
        carList.forEach(this::increaseForwardCountWithRandomMovement);
    }

    public List<Car> findGreatestForwardCount() {
        int maxCount = carList.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(Integer.MIN_VALUE);

        return carList.stream()
                .filter(car -> car.getForwardCount() == maxCount)
                .collect(Collectors.toList());
    }

    private void increaseForwardCountWithRandomMovement(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (isNumberGreaterThanOrEqualFour(random)) {
            car.increaseForwardCount();
        }
    }

    private boolean isNumberGreaterThanOrEqualFour(int number) {
        return number >= MOVE;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
