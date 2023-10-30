package racingcar.view;

import static java.lang.System.out;

import racingcar.model.ListOfCar;
import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void printResult(ListOfCar cars) {
        for (Car car : cars.getList()) {
            String name = car.getName();
            int gauge = car.getGauge();
            out.print(name + " : ");
            for (int i = 0; i < gauge; i++) {
                out.print("-");
            }
            out.println("");
        }
        out.println("");
    }

    public static void printWinner(ListOfCar cars) {
        int winnerScore = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars.getList()) {
            if (winnerScore < car.getGauge()) {
                winnerScore = car.getGauge();
                winners.clear();
                winners.add(car);
            } else if (winnerScore == car.getGauge()) {
                winners.add(car);
            }
        }
        List<String> winnersName = new ArrayList<>();
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }
        out.print("최종 우승자 : ");
        out.println(String.join(", ", winnersName));
    }
}
