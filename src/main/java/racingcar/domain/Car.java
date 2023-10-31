package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int position = 0;
    private String name = "";



    private Car(String name) {
        this.name = name;
    }

    public static List<Car> generate(List<String> cars) {
        List<Car> player = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            player.add(new Car(cars.get(i)));
        }
        return player;
    }

    private boolean ableMoveForward() {

        return false;
    }

    private int rollDice() {

        return 0;
    }
}
