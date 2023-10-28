package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;
    private static final String NEW_LINE = "\n";

    public Cars(List<String> names){
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void forward(){
        for(Car car : cars){
            car.forward();
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Car car : cars){
            result.append(car.toString());
            result.append(NEW_LINE);
        }
        return result.toString();
    }
}
