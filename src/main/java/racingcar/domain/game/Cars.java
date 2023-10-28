package racingcar.domain.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.util.NumberPicker;

public class Cars {
    private final List<Car> cars;

    private Cars(String input) {
        this.cars = convertToCarList(input);
    }

    public static Cars of(String input) {
        return new Cars(input);
    }

    private List<Car> convertToCarList(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::of)
                .toList();
    }

    public CarsDto moveOnce(NumberPicker numberPicker) {
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            CarDto carDto = car.moveOnce(numberPicker);
            carDtoList.add(carDto);
        }
        return new CarsDto(carDtoList);
    }
}
