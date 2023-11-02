package racingcar.model;

import racingcar.util.GameUtil;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private ArrayList<Car> cars = new ArrayList<>();

    public Cars(String input) {
        CarNameValidator validator = new CarNameValidator(input);
        for (String Name : validator.names) {
            Car car = new Car(Name);
            cars.add(car);
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move(GameUtil.getRandomNumber());
        }
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getCarPosition() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public HashMap<String, Integer> getCarStates() {
        LinkedHashMap<String, Integer> carsState = new LinkedHashMap<>();
        for (Car car : cars) {
            carsState.put(car.getCarName(), car.getCarPosition());
        }
        return carsState;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
