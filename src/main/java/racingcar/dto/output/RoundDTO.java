package racingcar.dto.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public final class RoundDTO {
    private final String name;
    private final int distance;

    private RoundDTO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<RoundDTO> of(List<Car> cars) {
        return cars.stream()
                .map(RoundDTO::carToRoundDTO)
                .collect(Collectors.toList());
    }

    private static RoundDTO carToRoundDTO(Car car) {
        return new RoundDTO(car.getName(), car.getDistance());
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, distance));
    }
}
