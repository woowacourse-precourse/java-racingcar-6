package racingcar.domain.car;

import java.util.List;
import racingcar.dto.CarInformationDto;
import racingcar.dto.CarNamesDto;
import racingcar.dto.CarsInformationDto;

public class Cars {

    private static final String CAR_NOT_FOUND_EXCEPTION_MESSAGE = "차가 존재하지 않습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarsExist(cars);
        this.cars = cars;
    }

    private void validateCarsExist(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(CAR_NOT_FOUND_EXCEPTION_MESSAGE);
        }
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
