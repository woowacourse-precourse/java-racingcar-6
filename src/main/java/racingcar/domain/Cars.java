package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private final String CAR_NAME_SEPERATOR = ",";
    private List<Car> cars = new ArrayList<>();

    public Cars(String inputValue) {
        List<String> carsName = parsedCarsName(inputValue);
        for(String carName : carsName) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<String> getWinnersName() {
        int maxMoveDistance = 0;
        List<String> winnersName = new ArrayList<>();
        for(Car car : cars) {
            if(car.getMoveDistance() > maxMoveDistance) {
                winnersName.clear();
                maxMoveDistance = car.getMoveDistance();
                winnersName.add(car.getName());
            } else if(car.getMoveDistance() == maxMoveDistance) {
                winnersName.add(car.getName());
            }
        }
        return winnersName;
    }

    private List<String> parsedCarsName(String inputValue) {
        return Arrays.asList(inputValue.split(CAR_NAME_SEPERATOR));
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
