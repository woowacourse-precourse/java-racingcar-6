package racingcar.domain;

import java.util.List;

public class RaceResultsPresenter {
    public void printRaceProcess(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++)
                sb.append("-");
            System.out.println(sb);
        }
        System.out.println("");
    }
}
