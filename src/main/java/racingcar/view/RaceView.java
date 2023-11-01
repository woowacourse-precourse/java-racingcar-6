package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class RaceView {
    private StringBuilder sb;
    private int carBoost;
    private String carName;
    private final String executionResult = "실행 결과";
    public void displayRaceResults(List<Car> cars) {
        System.out.println(executionResult);
        for (Car car : cars) {
            sb = new StringBuilder();

            carName = car.getCarName();
            carBoost = car.getCarBoost();

            sb.append(carName).append(" : ");
            carBoostToBar(carBoost);
            System.out.println(sb);
        }
        System.out.println();
    }

    public void carBoostToBar(int carBoost) {
        sb.append("-".repeat(Math.max(0, carBoost)));
    }

}
