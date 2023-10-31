package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.NumberGenerator;

public class Cars {

    private static final int STARTING_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = createCars(names);
    }

    public static Cars of(List<String> names) {
        return new Cars(names);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> Car.of(name, STARTING_POSITION))
                .toList();
    }

    public List<Car> race(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
        return get();
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinnerNames(){
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition){
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if(car.getPosition() > max ){
                max = car.getPosition();
            }
        }
        return max;
    }

}
