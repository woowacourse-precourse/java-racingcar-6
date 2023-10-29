package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarList {

    private final List<Car> carList;

    public CarList(List<String> carNameList) {
        carList = carNameList.stream().map(Car::new).toList();
    }

    public void race() {
        carList.forEach(this::increaseForwardCountWithRandomMovement);
    }

    private void increaseForwardCountWithRandomMovement(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (isNumberGreaterThanOrEqualFour(random)) {
            car.increaseForwardNumber();
        }
    }

    private boolean isNumberGreaterThanOrEqualFour(int number) {
        return number >= 4;
    }
}
