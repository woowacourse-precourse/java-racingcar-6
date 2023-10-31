package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class GameService {

    public static void playSingleRound(RacingGame racingGame) {
        if (!racingGame.isFinalRound()) {
            racingGame.nextRound();
            racingGame.getCars().forEach(CarService::moveIfRandomNumberExceedsFour);
        }
    }

    public static List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
