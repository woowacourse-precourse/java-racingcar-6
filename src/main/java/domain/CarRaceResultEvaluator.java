package domain;

import dto.WinnerDto;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceResultEvaluator {

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
                .getAsInt();
    }

    private boolean isCarAtMaxLocation(Car car, int maxLocation) {
        return car.getCarLocation().getValue() == maxLocation;
    }
}
