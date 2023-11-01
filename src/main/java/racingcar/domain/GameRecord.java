package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameRecord {

    private final List<String> winners = new ArrayList<>();

    public List<String> findWinner(List<Car> cars) {

        Car soloWinner = findSoloWinner(cars);
        findShareWinner(cars, soloWinner);

        return winners;
    }

    private void findShareWinner(List<Car> carList, Car soloWinner) {
        carList.stream()
                .filter(car -> 0 == car.compareTo(soloWinner))
                .forEach(car -> winners.add(car.toString()));
    }

    private Car findSoloWinner(List<Car> carList) {
        Optional<Car> firstWinnerOptional = carList.stream().max(Car::compareTo);
        return firstWinnerOptional.get();
    }
}
