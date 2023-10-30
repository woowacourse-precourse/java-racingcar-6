package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;


public class Cars {
    private List<Car> cars;
    private RandomGenerator randomGenerator;

    public Cars(List<String> carNames, RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(this::move);
    }

    private void move(Car car) {
        car.moveFoward(randomGenerator.generate());
    }

    public List<EachMoveResultDto> getEachGameResult() {
        return cars.stream()
                .map(this::getResult)
                .collect(Collectors.toList());
    }

    private EachMoveResultDto getResult(Car car) {
        return new EachMoveResultDto(car.getName(), car.getPosition());
    }

    public List<GameWinnerDto> getWinners() {
        return findWinningCars().stream()
                .map(car -> new GameWinnerDto(car.getName()))
                .collect(Collectors.toList());
    }

    private List<Car> findWinningCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Constants.ZERO);
    }
}
