package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int turn;
    public Racing(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public void startRacing() {
        for (int i = 0; i < turn; i++) {
            for (Car car : cars) {
                car.move();
            }
            printTurnResult();
        }
    }

    public List<Car> getWinners() {
        return null;
    }

    private void printTurnResult() {

    }


    public static void createRacingWithInput() {

    }

    private static void validateCreateRacingInput() {

    }
}
