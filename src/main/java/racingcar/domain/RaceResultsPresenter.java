package racingcar.domain;

import java.util.List;

public class RaceResultsPresenter {
    public void printRaceProcess(List<Car> cars) {
        for (Car car : cars) {
            String sb = car.getName()
                    + " : "
                    + "-".repeat(Math.max(0, car.getPosition()));
            System.out.println(sb);
        }
        System.out.println("");
    }
}