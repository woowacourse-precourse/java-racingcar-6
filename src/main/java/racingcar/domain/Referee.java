package racingcar.domain;

import java.util.List;
import java.util.Stack;

public class Referee {

    public static Stack<Car> pickWinners(List<Car> cars) {
        Stack<Car> winners = new Stack<>();
        for (Car car: cars) {
            if (winners.empty()) {
                winners.push(car);
                continue;
            }
            while (!winners.empty() && car.getMovedDistance() > winners.peek().getMovedDistance()) {
                winners.pop();
            }
            if (!winners.empty() && car.getMovedDistance() == winners.peek().getMovedDistance()) {
                winners.push(car);
            }
        }
        return winners;
    }
}
