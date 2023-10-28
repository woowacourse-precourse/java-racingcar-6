package racingcar.view;

import java.util.Collection;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public void printMoveResult(Cars cars) {
        Collection<Car> carList = cars.getCars();

        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.showDistance());
        }
    }
}
