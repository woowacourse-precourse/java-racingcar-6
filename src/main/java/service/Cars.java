package service;

import java.util.Collections;
import java.util.List;

public class Cars{
    private List<Car> car;

    public Cars(List<Car> car) {
        this.car = car;
    }

    public List<Car> getCar() {
        return car;
    }

    public void go(){
        car.forEach(Car::go);
    }

    public List<String> determineWinner(){
        List<String> name;
        name = car.stream()
                .filter(c -> c.getDistance()==getMaxDistance())
                        .map(Car::getName)
                                .toList();
        return name;
    }

    public int getMaxDistance(){
        List<Integer> distance;
        distance = car.stream().map(Car::getDistance).toList();
        return Collections.max(distance);
    }

}
