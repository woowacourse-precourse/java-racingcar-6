package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final static List<Car> racingCars = new ArrayList<>();

    public static void createCars(List<String> cars) {
        for (String car : cars) {
            racingCars.add(new Car(car, 0));
        }
    }

    public static void racing() {
        for (int i = 0; i < racingCars.size(); i++) {
            Car car = racingCars.get(i);
            car.go();
            System.out.println(car.getName() + " : " + "-".repeat(car.getAdvance()));
        }
    }

    public static String result() {
        int maxAdvance = 0;
        String winner = "";

        for (Car car : racingCars) {
            if (car.getAdvance() > maxAdvance) {
                maxAdvance = car.getAdvance();
                winner = car.getName();
            } else if (car.getAdvance() == maxAdvance) {
                winner = winner + ", " + car.getName();
            }
        }

        return winner;
    }
}
