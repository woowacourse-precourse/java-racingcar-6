package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class CarStart {

    private final List<Car> cars;

    public CarStart() {
        this.cars = new ArrayList<>();
    }

    public void racingGame() {
        lineUp();

    }

    public void lineUp() {
        String userInput;
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            userInput = Console.readLine();
            names = userInput.split(",");
        } while (!Valid.checkNames(names));
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

}
