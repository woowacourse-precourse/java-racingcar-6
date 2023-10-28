package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDTO;

public class Cars {
    private List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarDTO> playRound() {
        return this.cars.stream()
                .map(Car::playRound)
                .collect(Collectors.toList());
    }

    public List<CarDTO> getWinners() {
        int maxDistance = cars.stream()
                .mapToInt(car -> car.getDistance())
                .max()
                .orElse(0);
        List<Car> winners = cars.stream()
                .filter(car -> car.getDistance()==maxDistance)
                .collect(Collectors.toList());
        return winners.stream()
                .map(car -> CarDTO.from(car))
                .collect(Collectors.toList());
    }
}
