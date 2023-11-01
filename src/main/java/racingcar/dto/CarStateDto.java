package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarStateDto {
    String name;
    int path;

    public CarStateDto(String name, int path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public int getPath() {
        return path;
    }

    public static List<CarStateDto> makeDto(List<Car> carList) {
        return carList.stream()
                .map(car -> new CarStateDto(car.getName(), car.getPath()))
                .collect(Collectors.toList());
    }
}
