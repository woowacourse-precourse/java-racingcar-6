package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public static void displayStaticOutView() {
        System.out.println("실행 결과");
    }

    public static void displayOutputView(Cars cars) {
        List<Car> carList = cars.getCarList();

        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
    }
}
