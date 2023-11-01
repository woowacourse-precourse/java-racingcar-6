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

    public int getChance() {
        return chance;
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

    public void exec() {
        if (chance <= 0) {
            throw new IllegalStateException("이동 횟수를 모두 소모했습니다.");
        }
        for (Car car : cars) {
            car.move();
        }
    }

    public String showStatus() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }
}
