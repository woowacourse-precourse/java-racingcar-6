package racingcar;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RacingCars {
    private final LinkedList<Car> cars;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public RacingCars(LinkedList<Car> cars){
        validateCarNames(cars);
        checkDuplicateNames(cars);
        this.cars = cars;
    }

    private void validateCarNames(LinkedList<Car> cars){
        cars.forEach(car -> {
            if (car.getName().length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("차의 이름은 5글자를 넘을 수 없습니다.");
            }
        });
    }

    private void checkDuplicateNames(LinkedList<Car> cars){
        Set<String> nameSet = new HashSet<>();
        cars.forEach(car -> nameSet.add(car.getName()));
        if (nameSet.size() < cars.size()){
            throw new IllegalArgumentException("중복되는 자동차 이름은 사용할 수 없습니다.");
        }
    }

    protected void moveCars(Dice dice){
        cars.forEach(car -> car.move(dice));
        System.out.println();
    }

    protected LinkedList<String> getWinners(){
        int max = 0;
        LinkedList<String> winners = new LinkedList<>();
        for (Car car : cars) {
            if (car.getPosition() >= max) {
                max = car.getPosition();
            }
        }
        for (Car car: cars){
            if (max != 0 && car.getPosition() == max){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
