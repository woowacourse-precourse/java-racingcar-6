package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printResult(List<Car> results) {
        StringBuilder resultBuilder = new StringBuilder();

        for (Car result : results) {
            int repeat = result.getProgress();
            resultBuilder.append(result.getName()).append(" : ");
            resultBuilder.append("-".repeat(repeat)).append("\n");
        }

        System.out.println(resultBuilder.toString());
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
