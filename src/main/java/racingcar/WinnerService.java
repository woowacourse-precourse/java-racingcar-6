package racingcar;

import java.util.LinkedList;
import java.util.List;

public class WinnerService {
    
    private final List<Car> winners = new LinkedList<>();
    
    public List<Car> getWinners(List<Car> cars) {
        executeWinner(cars);
        return winners;
    }
    
    private void executeWinner(List<Car> cars) {
        int maxLocation = calculateMaxLocation(cars);
        for (Car car : cars) {
            determineWinner(car, maxLocation);
            addWinner(car);
        }
    }
    
    private int calculateMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.location)
                .max()
                .orElse(0);
    }
    
    private static void determineWinner(Car car, int maxLocation) {
        if (car.location == maxLocation) {
            car.setWinner();
        }
    }
    
    private void addWinner(Car car) {
        if (car.isWinner) {
            winners.add(car);
        }
    }
}
