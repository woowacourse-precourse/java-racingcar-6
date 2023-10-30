package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class WinnerView {
    public static void displayWinnerView(Cars cars) {
        System.out.print("최종 우승자 : ");

        List<String> carNames = new ArrayList<>();

        for (Car car : cars.getCarList()) {
            carNames.add(car.getName());
        }

        System.out.print(String.join(", ", carNames));
    }
}
