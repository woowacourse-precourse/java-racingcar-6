package racingcar.domain;

import java.util.List;
import java.util.Stack;

public class Referee {

    public static Stack<Car> pickWinners(List<Car> cars) {
        Stack<Car> winners = new Stack<>();
        for (Car car: cars) {
            while (!winners.empty() && winners.peek().getMovedDistance() < car.getMovedDistance()) {
                winners.pop();
            }
            if (winners.empty() || winners.peek().getMovedDistance() == car.getMovedDistance()) {
                winners.push(car);
            }
        }
        return winners;
    }
}
