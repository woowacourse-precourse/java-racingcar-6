package racingcar.evaluator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class Evaluator {

    private PrintWinner printWinner;

    public void evaluate(List<Car> cars) {
        List<String> winners = evaluateWinner(cars);
        printWinner.print(winners);
    }

    public List<String> evaluateWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        cars.sort(Comparator.comparingInt(Car::getMoving));
        int moving = cars.get(cars.size() - 1).getMoving();

        for (Car car : cars) {
            if (car.getMoving() == moving) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
