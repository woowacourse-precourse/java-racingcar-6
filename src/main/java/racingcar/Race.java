package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    final private List<Car> cars;
    final private int time;

    public Race() {
        String[] names = Screen.askCarNames();
        time = Screen.askRacingTime();
        cars = new ArrayList<>();

        for (String name : names)
            cars.add(new Car(name));
    }

    public void run() {
        System.out.println("\n실행 결과");
        for (int idx = 0; idx < time; idx++) {
            playOneRound();
            Screen.displayResult(cars);
        }
        Screen.displayWinners(cars);
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.moveFoward();
        }
    }
}
