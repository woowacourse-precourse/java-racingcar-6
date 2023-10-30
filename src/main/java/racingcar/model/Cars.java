package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names){
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void move(){
        for(Car car : cars){
            car.moveOneStep();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
