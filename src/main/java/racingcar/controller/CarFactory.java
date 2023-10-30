package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            if (carName.length() >= 6) throw new IllegalArgumentException("이름은 5자 이하만 가능하다.");
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

}
