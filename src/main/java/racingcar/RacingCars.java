package racingcar;

import java.util.LinkedList;

public class RacingCars {
    private LinkedList<Car> cars;

    public RacingCars(LinkedList<Car> cars){
        validateCarNames(cars);
        this.cars = cars;
    }

    private void validateCarNames(LinkedList<Car> cars){
        cars.forEach(car -> {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자를 넘을 수 없습니다.");
            }
        });
    }

    private void moveCars(Dice dice){
        cars.forEach(car -> car.move(dice));
    }
}
