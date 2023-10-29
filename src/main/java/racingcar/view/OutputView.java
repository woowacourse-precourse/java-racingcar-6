package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void displayPerResults(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
