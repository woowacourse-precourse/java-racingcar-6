package racingcar.view;

import racingcar.model.Car;

public class GameView {
    public static void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void printMoveStatus(Car car) {
        StringBuilder status = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMoveStatus(); i++) {
            status.append("-");
        }
        System.out.println(status);
    }
}
