package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String positionFormat = "-";

    public static void executeResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : " + printPosition(car.getMove()));
        }
        System.out.println();
    }

    private static String printPosition(int move) {
        return positionFormat.repeat(move);
    }
}
