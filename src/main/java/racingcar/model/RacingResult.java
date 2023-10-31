package racingcar.model;

import java.util.List;

public class RacingResult {

    private Cars cars;

    public RacingResult(Cars cars) {
        this.cars = cars;
    }

    public String winners() {
        StringBuilder sb = new StringBuilder();
        for (String winner : findWinners()) {
            sb.append(winner)
                    .append(SpecialSign.SEPARATOR.getSign())
                    .append(SpecialSign.SPACE.getSign());
        }
        return sb.substring(0, sb.length() - 2);
    }

    private List<String> findWinners() {
        int maxDistance = cars.maxDistance();
        return cars.getCars().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> car.getName())
                .toList();
    }
}
