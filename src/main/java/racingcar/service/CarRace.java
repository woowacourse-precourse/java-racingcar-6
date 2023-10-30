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
    public void moveForward(int randomNumber) {
        cars.stream()
                .filter(car -> randomNumber >= Numbers.MOVE_POSITION_NUMBER.getNumber())
                .forEach(car -> car.updatePosition());
    }

    public void printPlayers() {
        int randomNumber = randomGenerator();
        moveForward(randomNumber);
        cars.stream()
                .map(car -> car.getName() + " : " + car.getPosition())
                .forEach(System.out::println);
        System.out.println();
    }
}
