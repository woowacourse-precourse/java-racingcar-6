package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    List<Car> roster = new ArrayList<>();

    public Roster(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            roster.add(new Car(carName));
        }
    }
}
