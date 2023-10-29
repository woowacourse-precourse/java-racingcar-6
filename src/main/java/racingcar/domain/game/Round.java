package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.dto.CarDto;
import racingcar.mapper.CarMapper;

public class Round {
    private final List<Integer> numbers;
    private final Cars cars;

    public Round(List<Integer> numbers, Cars cars) {
        this.numbers = numbers;
        this.cars = cars;
    }

    public void race() {
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.findCarByIndex(index);
            car.move(numbers.get(index));
        }
    }

    public List<CarDto> getResult() {
        return CarMapper.convertToCarDtoList(cars);
    }
}
