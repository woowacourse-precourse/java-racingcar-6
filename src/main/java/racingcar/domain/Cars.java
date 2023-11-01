package racingcar.domain;

import java.util.List;
import racingcar.domain.dto.CarDto;
import racingcar.util.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> names) {
        this.cars = mapToCars(names);
    }

    public static Cars from(List<String> names) {
        return new Cars(names);
    }

    private List<Car> mapToCars(List<String> names) {
        return names.stream()
                .map(Car::from)
                .toList();
    }

    public void race(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<CarDto> toDto() {
        return cars.stream()
                .map(Car::toDto)
                .toList();
    }

    public List<String> getWinnerNames(){
        List<CarDto> carDtos = toDto();

        int maxPosition = findMaxPosition(carDtos);
        return findWinnerNamesBy(maxPosition, carDtos);
    }


    private int findMaxPosition(List<CarDto> cars) {
        return cars.stream()
                .mapToInt(CarDto::position)
                .max()
                .orElse(Position.INITIAL_POSITION);
    }

    private List<String> findWinnerNamesBy(int maxPosition, List<CarDto> cars) {
        return cars.stream()
                .filter(car -> car.position() == maxPosition)
                .map(CarDto::name)
                .toList();
    }
}
