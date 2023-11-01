package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public void printDistance(List<Car> carList) {
        for (Car car : carList) {
            int distance = car.getDistance();
            String name = car.getName();

            System.out.print(name + " : ");
            System.out.println("-".repeat(distance));
        }
    }

    public void printWinner(List<Car> winnerList) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winnerList) {
            winnerNames.add(car.getName());
        }

        System.out.print(String.join(", ", winnerNames));
    }
}
