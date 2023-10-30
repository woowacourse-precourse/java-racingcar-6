package racingcar.view;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.position.Position;

public class OutputView {

    public void showRoundResult(List<Car> cars) {
        System.out.println(resolveRoundResultMessage(cars));
    }

    public void showGameResult(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        System.out.println(resolveWinnerMessage(winners));
    }

    private List<Car> getWinners(List<Car> cars) {
        Position furthestPosition = getFurthestPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition().equals(furthestPosition))
                .collect(Collectors.toList());
    }


    private Position getFurthestPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    private String resolveWinnerMessage(List<Car> winners) {
        if (winners.size() == 1) {
            return "최종 우승자 : " + winners.get(0).getCarName();
        }
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
        return "최종 우승자 : " + winnerNames;
    }

    private String resolveRoundResultMessage(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getCarName()).append(" : ");
            Position position = car.getPosition();
            result.append(position.draw());
            result.append("\n");
        }
        return result.toString();
    }
}
