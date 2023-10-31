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

    private int randomGenerator(int min, int max) {
        int randomNumber = Randoms.pickNumberInRange(min, max);
        return randomNumber;
    }
    public void moveForward(int min, int max) {
        cars.stream()
                .filter(car -> randomGenerator(min, max) >= Numbers.MOVE_POSITION_NUMBER.getNumber())
                .forEach(car -> car.updatePosition());
    }

    public void printPlayers() {
        moveForward(Numbers.RANDOM_START_NUMBER.getNumber() , Numbers.RANDOM_END_NUMBER.getNumber());
        cars.stream()
                .map(car -> car.getName() + " : " + car.getPosition())
                .forEach(System.out::println);
        System.out.println();
    }
}
