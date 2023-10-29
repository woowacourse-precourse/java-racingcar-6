package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Numbers;

import java.util.List;

public class CarRace {

    private final List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
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
                .map(car -> car.getName() + " : " + car.getPosition())
                .forEach(System.out::println);
        System.out.println();
    }
}
