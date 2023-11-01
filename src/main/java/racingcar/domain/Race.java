package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    int chance;
    List<Car> cars;

    public Race(String number) {
        try{
            chance = Integer.parseInt(number);
            cars = new ArrayList<>();
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 자연수여야 합니다.");
        }
    }

    public void addCar(Car car) {
        if (containsDuplicatedName(car)) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
        this.cars.add(car);
    }

    private boolean containsDuplicatedName(Car car) {
        String carName = car.getName();
        for (Car other : cars) {
            if (other.getName().equals(carName)) {
                return true;
            }
        }
        return false;
    }
}
