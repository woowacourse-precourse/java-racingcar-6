package racingcar.IO;

import java.util.List;
import racingcar.Model.Car;

public class Output {
    public static void printWinners(List<Car> cars, int longestDistance) {

        StringBuilder winners = new StringBuilder();

        for (Car car : cars) {
            if (car.getLength() == longestDistance) {
                winners.append(car.getName());
                winners.append(", ");
            }
        }

        winners.delete(winners.length() - 2, winners.length());

        System.out.println("최종 우승자 : " + winners);
    }
}
