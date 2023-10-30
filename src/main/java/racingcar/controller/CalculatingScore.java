package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Order;

import java.util.List;

public class CalculatingScore {
    private int maxScore = Integer.MIN_VALUE;
    private Order order = new Order();
    public void result(List<Car> carList, List<String> winner) {
        order.printWinner();

        for (Car car : carList) {
            int carScore = locate(car);

            if (carScore > maxScore) {
                maxScore = carScore;
                winner.clear();
                plus(winner, car.getName());
            }

            else if (carScore == maxScore) {
                plus(winner, car.getName());
            }
        }
    }

    private void plus(List<String> winner, String name) {
        winner.add(name);
    }

    private int locate(Car car) {
        return score(car.getMove());
    }

    private int score(String move) {
        return move.length();
    }
}
