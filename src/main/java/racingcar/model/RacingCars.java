package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }


    public void addCars(String[] carNames) {
        Arrays.stream(carNames).forEach(name -> racingCars.add(new Car(name)));
    }


    public void move() {

        for (Car car : racingCars) {
            car.move(createRandomNumber());
        }

    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
