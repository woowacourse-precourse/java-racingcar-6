package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class View {

    void showResult(List<Car> carList) {
        int count = 0;

        for (Car car : carList) {
            System.out.print(car.getName());

            count++;
            if (count < carList.size()) {
                System.out.print(", ");
            }
        }
    }
}
