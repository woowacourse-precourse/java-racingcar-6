package racingcar.domain.game;

import racingcar.dto.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameWinnerFinder {
    private List<Car> gameParticipant;
    public GameWinnerFinder(List<Car> carList) {
        gameParticipant = carList;
    }

    public List<Car> findWinner() {
        List<Car> carsWithMaxPosition = new ArrayList<>();

        Optional<Integer> maxPosition = gameParticipant.stream()
                .map(Car::position)
                .max(Integer::compareTo);

        if (maxPosition.isPresent()) {
            carsWithMaxPosition = gameParticipant.stream()
                    .filter(car -> car.position().equals(maxPosition.get()))
                    .toList();
        }

        return carsWithMaxPosition;
    }
}
