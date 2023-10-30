package racingcar.View;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printProgressStatus(String progressStatus) {
        System.out.println(progressStatus);
    }

    public void printWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자 : ");
        sb.append(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            sb.append(", ").append(cars.get(i).getName());
        }

        System.out.println(sb);
    }
}
