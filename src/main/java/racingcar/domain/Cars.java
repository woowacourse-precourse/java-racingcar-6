package racingcar.domain;

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

    public List<Car> getCars() {
        return cars;
    }
}