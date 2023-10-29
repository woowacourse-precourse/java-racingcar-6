package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class OutputView {

    public void showRoundResult(List<Car> cars) {
        System.out.println(resolveRoundResultMessage(cars));
    }

    public void showGameResult(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        System.out.println(resolveWinnerMessage(winners));
    }

    private List<Car> getWinners(List<Car> cars) {
        int furthestPosition = getFurthestPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == furthestPosition)
                .collect(Collectors.toList());
    }

    private int getFurthestPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private String resolveWinnerMessage(List<Car> winners) {
        if (winners.size() == 1) {
            return "최종 우승자 : " + winners.get(0).getName();
        }
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        return "최종 우승자 : " + winnerNames;
    }

    private String resolveRoundResultMessage(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName() + " : ");
            int position = car.getPosition();
            for (int i = 0; i < position; i++) {
                result.append("-");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
