package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Numbers;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int randomGenerator() {
        int randomNumber = Randoms.pickNumberInRange(
                Numbers.RANDOM_START_NUMBER.getNumber(),
                Numbers.RANDOM_END_NUMBER.getNumber()
        );
        return randomNumber;
    }

    private void moveForward() {
        cars.stream()
                .filter(car -> randomGenerator() >= Numbers.MOVE_POSITION_NUMBER.getNumber())
                .forEach(car -> car.updatePosition());
    }

    public void printPlayers() {
        moveForward();
        cars.stream()
                .forEach(car -> {
                    System.out.print(car.getName() + " : ");
                    System.out.println(car.getPosition());
                });
        System.out.println();
    }

}
