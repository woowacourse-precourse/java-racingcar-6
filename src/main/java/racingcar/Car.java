package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int forwardValue;

    Car(String name) {
        this.name = name;
    }

    public static List<Car> getNames() {
        List<Car> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        if(isValidateNames(carNames)) {
            for(String carName : carNames.split((","))) {
                cars.add(new Car(carName));
            }
        }
        return cars;
    }

    private static boolean isValidateNames(String carNames) {
        String[] splitCarNames = carNames.split(",");
        for(String carName : splitCarNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
