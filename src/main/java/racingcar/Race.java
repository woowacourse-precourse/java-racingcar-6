package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int time;

    public Race() {
        String[] names = Screen.askCarNames();
        time = Screen.askRacingTime();
        cars = new ArrayList<>();

        for (String name : names)
            cars.add(new Car(name));
    }
}
