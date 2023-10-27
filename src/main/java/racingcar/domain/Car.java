package racingcar.domain;


import racingcar.utils.GameRules;
import racingcar.validation.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = GameRules.START_POSITION.getValue();
    }

    public static List<Car> createCarFrom(List<String> name) {
        InputValidation inputValidation = new InputValidation();
        List<Car> cars = new ArrayList<>();
        for (String carName : name) {
            inputValidation.carNameValidation(carName);
            cars.add(createCar(carName));
        }
        return cars;
    }

    private static Car createCar(String name) {
        return new Car(name);
    }

    public void go() {
        int randomNumber = NumberGenerator.generateNumber();
        if (randomNumber > GameRules.GO_CONDITION.getValue()) {
            this.position++;
        }
    }

    public boolean isWinner(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
