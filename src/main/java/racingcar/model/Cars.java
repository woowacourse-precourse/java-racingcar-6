package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {

    private static List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void randomGenerator() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4){
            moveForward();
        }
    }

    private void moveForward() {
        cars.stream().forEach(car -> car.updatePosition());
    }
}
