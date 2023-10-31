package racingcar.domain.car;

import java.util.List;
import racingcar.dto.CarInformationDto;
import racingcar.dto.CarNamesDto;
import racingcar.dto.CarsInformationDto;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public CarsInformationDto getInformation() {
        List<CarInformationDto> carInformationDtoList = cars.stream()
                .map(car -> car.getInformation())
                .toList();
        return new CarsInformationDto(carInformationDtoList);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public CarNamesDto findWinnerNames() {
        int maxPosition = getMaxPosition();
        return findCarNamesByPosition(maxPosition);
    }

    public CarNamesDto findCarNamesByPosition(int position) {
        List<String> carNames = cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .toList();
        return new CarNamesDto(carNames);
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Cars anotherCars = (Cars) obj;
        return cars.equals(anotherCars.cars);
    }

}
