package racingcar.model;

import racingcar.DTO.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private static final int INITIAL_ROUND = 0;
    private static int currentRoundCount = INITIAL_ROUND;
    private List<CarDTO> roundResult;

    public void startRace(List<Car> cars) {
        cars.forEach(Car::startEngine);
    }

    public void endRace() {
        currentRoundCount++;
    }

    public List<CarDTO> generateResult(List<Car> cars) {
        roundResult = cars.stream()
                .map(car -> new CarDTO(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        return roundResult;
    }

    public static int getCurrentRoundCount() {
        return currentRoundCount;
    }
}
