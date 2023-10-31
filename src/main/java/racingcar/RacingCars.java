package racingcar;

import java.util.LinkedList;

public class RacingCars {
    private final LinkedList<Car> cars;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public RacingCars(LinkedList<Car> cars){
        validateCarNames(cars);
        this.cars = cars;
    }

    private void validateCarNames(LinkedList<Car> cars){
        cars.forEach(car -> {
            if (car.getName().length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("차의 이름은 5글자를 넘을 수 없습니다.");
            }
        });
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
            if (car.getPosition() == max){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
