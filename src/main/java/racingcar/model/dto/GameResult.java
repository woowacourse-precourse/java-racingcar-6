package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public record GameResult(List<String> winners) {

    public static GameResult fromCars(List<Car> cars) {
        Long winnerPosition = findWinnerPosition(cars);
        List<String> players = findPlayersByPosition(cars, winnerPosition);

        return new GameResult(players);
    }

    private static List<String> findPlayersByPosition(List<Car> cars, Long position) {
        List<String> players = new ArrayList<>();

        for(Car car : cars) {
            if(car.getPosition() == position)
                players.add(car.getName());
        }
        return players;
    }

    private static Long findWinnerPosition(List<Car> cars) {
        Long position = Long.MIN_VALUE;

        for(Car car : cars) {
            if (car.getPosition() > position) {
                position = car.getPosition();
            }
        }
        return position;
    }
}
