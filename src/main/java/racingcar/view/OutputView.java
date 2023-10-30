package racingcar.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;

public class OutputView {


    public void showRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.carName + " : " + "-".repeat(car.carPosition));
        }

    }

    public String selectWinner(List<Car> carList) {
        List<Integer> carPosition = new ArrayList<>();
        for (Car car : carList) {
            carPosition.add(car.carPosition);
        }
        int max = Collections.max(carPosition);
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.carPosition == max) {
                winners.add(car.carName);
            }
        }
        String result = String.join(",", winners);

        return result;
    }
}
