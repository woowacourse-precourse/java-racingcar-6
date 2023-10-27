package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getDisplayStatus() {
        StringBuilder status = new StringBuilder();
        status.append(name).append(" : ").append("-".repeat(position));
        return status.toString();
    }

    public static List<CarDto> from(List<Car> cars) {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }
}

