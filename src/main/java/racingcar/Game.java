package racingcar;

import java.util.ArrayList;

public class Game {
    public static void runGame(ArrayList<Car> cars, int counts) {
        for (int i = 0; i < counts; i++) {
            for (Car car : cars) {
                car.move();
            }
            System.out.println();
        }
    }

}
