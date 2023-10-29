package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars){
        this.cars = cars;
    }

    public static Cars from(CarNames carNames){
        List<Car> cars = generateCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> generateCars(CarNames carNames){
        return carNames.getNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(){
        for (Car car : cars) {
            car.movePosition();
        }
    }

    public List<Car> getWinnerCars() {
        Position position = getMaxPosition();
        return getMaxWinnerCars(position);
    }

    private List<Car> getMaxWinnerCars(Position position){
        return this.cars.stream()
                .filter(car -> car.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        int max = cars.stream()
                .mapToInt(car -> car.getPosition().getPosition())
                .max()
                .getAsInt();

        return new Position(max);
    }

    public List<Car> getCars() {
        return cars;
    }
}