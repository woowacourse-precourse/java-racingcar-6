package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.model.Car;

public class CarFactory {

    public List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            if (carName.length() >= 6) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능하다.");
            }
            // TODO: 이름이 알파벳이 아니게 주어진 경우
            if (!isAlpha(carName)) {
                throw new IllegalArgumentException("이름은 알파벳으로 이루어져야 한다.");
            }
            // TODO: 똑같은 이름이 주어진 경우
            if (carName.contains(carName)) {
                throw new IllegalArgumentException("똑같은 이름이 입력되면 안된다.");
            }

            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    boolean isAlpha(String carName) {
        return Pattern.matches("^[a-zA-Z]*$", carName);

    }

}
