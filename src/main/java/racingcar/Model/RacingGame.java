package racingcar.Model;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }

        for (Car car : cars) {
            car.getName();
        }
    }

    public static void startGame() {
        int round = 0;
        System.out.println("실행결과");
        do {
            System.out.printf("round: %d\n", round + 1);
            round++;
        } while (round < Settings.ATTEMPT_COUNT);
    }

}
