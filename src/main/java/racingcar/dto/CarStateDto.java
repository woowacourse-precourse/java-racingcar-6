package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarStateDto {
    String name;
    int path;

    private CarStateDto(String name, int path) {
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
        List<CarStateDto> carStateDtoList = new ArrayList<>();
        for (Car car: carList) {
            carStateDtoList.add(new CarStateDto(car.getName(), car.getPath()));
        }

        return carStateDtoList;
    }
}
