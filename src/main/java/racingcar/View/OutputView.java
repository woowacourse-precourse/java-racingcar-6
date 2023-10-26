package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName()+" : ");
            printPosition(car.getPosition());
        }
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
