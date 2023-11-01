package racingcar.view;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.List;

public class ResultsPrinter {
    public void printResults(Race race) {
        for (Car car : race.getCars()) {
            String progress = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
