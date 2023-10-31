package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String WINNER = "최종 우승자 : ";

    public static void carsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(carStatus(car));
        }
        System.out.println();
    }

    private static String carStatus(Car car) {
        return car.getCarName() + " : " + car.getPosition();
    }

    public static void winner(String winner) {
        System.out.println(WINNER + winner);
    }
}
