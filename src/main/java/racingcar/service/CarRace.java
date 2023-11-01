package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
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

    private boolean shouldMoveForward(int min, int max) {
        if (randomGenerator(min, max) >= Numbers.MOVE_POSITION_NUMBER.getNumber()){
            return true;
        }
        return false;
    }
    public void moveForward(int min, int max) {
        cars.stream()
                .filter(car -> shouldMoveForward(min, max))
                .forEach(car -> car.updatePosition());
    }

    public void printPlayersWithPositions() {
        moveForward(Numbers.RANDOM_START_NUMBER.getNumber() , Numbers.RANDOM_END_NUMBER.getNumber());
        cars.stream()
                .map(car -> car.getName() + " : " + car.getPosition())
                .forEach(System.out::println);
        System.out.println();
    }
}
