package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car.Car;

public class CarRepository {

    private List<Car> carList;

    public CarRepository(List<Car> carList) {
        this.carList = carList;
    }

    public void save(Car car) {
        carList.add(car);
    }

    public Car getCar(int index){
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }

    //테스트를 위한 getter
    public List getCarRepository(){
        return new ArrayList<>(carList);
    }
}
