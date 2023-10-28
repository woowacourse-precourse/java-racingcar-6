package racingcar;

import java.util.ArrayList;
import java.util.List;

public class PrintFunction {

    void printScore(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.name + " : " + "-".repeat(car.score));
        }
        System.out.println();
    }

    void printWinner(List<Car> carList) {
        List<String> winnerName = new ArrayList<>();
        int max = 0;
        for (Car car : carList) {
            if (max < car.score) {
                max = car.score;
            }
        }

        for (Car car : carList) {
            if (car.score == max) {
                winnerName.add(car.name);
            }
        }
        String result = String.join(", ", winnerName);
        System.out.print("최종 우승자 : ");
        System.out.println(result);
    }
}
