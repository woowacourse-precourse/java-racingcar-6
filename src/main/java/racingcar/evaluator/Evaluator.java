package racingcar.evaluator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.message.Printer;

public class Evaluator {

    public void evaluate(List<Car> cars) {
        List<String> winners = evaluateWinner(cars);
        printWinners(winners);
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

    private void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            printSingleWinner(winners.get(0));
        } else {
            printMultipleWinners(winners);
        }
    }

    private void printSingleWinner(String winner) {
        Printer.resultWinner(winner);
    }

    private void printMultipleWinners(List<String> winners) {
        String result = buildWinner(winners);
        Printer.resultWinner(result);
    }

    private String buildWinner(List<String> winners) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i));

            if (i < winners.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
