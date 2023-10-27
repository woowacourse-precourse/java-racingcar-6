package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carName) {
        for (String name : carName) {
            addCar(new Car(name));
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<EachMoveResultDto> moveCarsAndCollectResults() {
        List<EachMoveResultDto> moveResults = new ArrayList<>();
        for (Car car : cars) {
            moveCarForward(car);
            collectMoveResult(moveResults, car);
        }
        return moveResults;
    }

    private void moveCarForward(Car car) {
        RandomGenerator randomGenerator = new RandomGenerator();
        car.moveFoward(randomGenerator.generate());
    }

    private void collectMoveResult(List<EachMoveResultDto> moveResults, Car car) {
        EachMoveResultDto moveResultDto = new EachMoveResultDto(car.getName(), car.getPosition());
        moveResults.add(moveResultDto);
    }

    public List<GameWinnerDto> findWinnersDto() {
        List<GameWinnerDto> gameWinnerDtos = new ArrayList<>();
        for (Car winners : findWinners()) {
            gameWinnerDtos.add(new GameWinnerDto(winners.getName()));
        }
        return gameWinnerDtos;
    }

    private List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
