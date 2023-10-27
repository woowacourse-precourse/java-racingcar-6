package racingcar;

import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars=cars;
    }

    public void attemptForward(){
        for(Car car:cars){
            car.attemptForward();
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<Car> findWiiningCars(){
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream().toList();
    }
}
