package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ViewOutput {
    private StringBuilder stringBuilder;

    public void printRoundResult(List<Car> cars) {
        for(Car car : cars) {
            stringBuilder.append(car.getName() + "-".repeat(car.getCurrentLocation()));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

}
