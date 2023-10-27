package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stadium {
    private final List<Car> cars = new ArrayList<>();

    public Stadium() {
    }

    String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    void saveInputCars(String inputCars) {
        List<String> carNames = List.of(inputCars.split(","));
        for (String name : carNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 한다.");
            }
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
