package racingcar.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import racingcar.model.Car;

public class OutputView {
    public static void printRaceStatus(List<Car> cars) {
        StringBuilder status = new StringBuilder();
        for (Car car : cars) {
            status.append(car.name).append(" : ");
            for (int i = 0; i < car.location; i++) {
                status.append('-');
            }
            status.append('\n');
        }
        System.out.println(status);
    }

    public static void printWinner(List<Car> winners) {
        StringBuilder winnerBuilder = new StringBuilder();
        winnerBuilder.append("최종 우승자 : ");
        Queue<Car> winnerQueue = new LinkedList<>(winners);
        while (winnerQueue.size() > 1) {
            winnerBuilder.append(winnerQueue.poll().name).append(", ");
        }
        winnerBuilder.append(winnerQueue.poll().name);
        System.out.println(winnerBuilder);
    }
}
