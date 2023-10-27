package racingcar;

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
}
