package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Order;

import java.util.List;

public class CalculatingScore {
    private Order order = new Order();
    public void result(List<Car> carList, List<String> winner) {
        order.printWinner();
        int maxPoint = Integer.MIN_VALUE;

        for (Car car : carList) {
            int carPoint = point(car);

            if (carPoint > maxPoint) {
                maxPoint = carPoint;
                winner.clear();
                winner.add(car.getName());
            }

            else if (carPoint == maxPoint) {
                winner.add(car.getName());
            }
        }
    }
    private int point(Car car) {
        return score(car.getMove());
    }

    private int score(String move) {
        return move.length();
    }
}
