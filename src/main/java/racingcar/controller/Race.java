package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private final List<Car> cars;

    public Race(String carNames) {
        this.cars = initializeCars(carNames.split(","));
    }

    private List<Car> initializeCars(String[] names) {
        List<Car> carList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            validateCars(nameList, name);
            carList.add(new Car(name));
            nameList.add(name);
        }
        return carList;
    }

    private void validateCars(List<String> nameList, String name) {
        if (name.length()>5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        if (nameList.contains(name)) throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
    }

    public void run() {
        cars.forEach(car -> car.move(pickNumberInRange(0, 9)));
    }

    public List<Car> getCars() {
        return cars;
    }
}


