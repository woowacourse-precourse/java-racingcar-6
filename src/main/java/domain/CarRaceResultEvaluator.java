package domain;

import dto.WinnerDto;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceResultEvaluator {

    private static final int DEFAULT_MAX_VALUE = 0;

    public WinnerDto getWinners(Cars cars) {
        int maxLocation = getMaxLocation(cars.getAllCars());
        List<String> winnerNames = cars.getAllCars().stream()
                .filter(car -> isCarAtMaxLocation(car, maxLocation))
                .map(car -> car.getCarName().getValue())
                .collect(Collectors.toList());
        return new WinnerDto(winnerNames);
    }

    private int getMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getCarLocation().getValue())
                .max()
                .orElse(DEFAULT_MAX_VALUE);
    }

    private boolean isCarAtMaxLocation(Car car, int maxLocation) {
        return car.getCarLocation().getValue() == maxLocation;
    }
}
