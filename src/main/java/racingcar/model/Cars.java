package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.moveForward(randomNumber);
        }
    }
}
