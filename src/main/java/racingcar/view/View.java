package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class View {

    public void showResult(List<Car> carList) {
        int count = 0;

        for (Car car : carList) {
            System.out.print(car.getName());

            count++;
            if (count < carList.size()) {
                System.out.print(", ");
            }
        }
    }

    public void showPhase(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printDistance(car);
        }
        System.out.println();
    }

    private static void printDistance(Car car) {
        for (int count = 0; count < car.getDistance(); count++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
