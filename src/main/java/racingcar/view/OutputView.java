package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printCarInfo(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            if (i == cars.size() - 1) {
                stringBuilder.append(cars.get(i).getName() + "\n");
            } else {
                stringBuilder.append(cars.get(i).getName() + ", ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
