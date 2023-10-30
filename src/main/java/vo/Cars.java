package vo;

import java.util.List;
import service.Car;

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

}
