package racingcar.view;

import racingcar.common.Message;
import racingcar.entity.Car;

import java.util.List;

public class OutputView {

    public void printCarScores(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(Message.getDistance(car));
        }
        System.out.println();
    }

    public void printStart() {
        System.out.println(Message.START);
    }

    public void printPlayCount() {
        System.out.println(Message.COUNT);
    }

    public void printWinner(List<String> winners) {
        System.out.println(Message.WINNER.getMessage() + String.join(", ", winners));
    }
    
}
