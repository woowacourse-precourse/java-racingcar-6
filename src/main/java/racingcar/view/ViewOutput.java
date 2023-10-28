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
        stringBuilder.setLength(0);
    }

    public void printWinner(List<Car> winnerCars) {
        stringBuilder.append("최종 우승자 : ");
        for(Car car : winnerCars) {
            stringBuilder.append(car.getName() + ", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);

        System.out.println(stringBuilder);
    }
}
