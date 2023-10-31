package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        forwardCount = 0;
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void attemptForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            forwardCount++;
        }
    }

}
