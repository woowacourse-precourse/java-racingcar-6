package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carList = new ArrayList<>();
    public RacingCars(List<String> carNames){
        carNames.forEach(car -> carList.add(new Car(car)));
    }
    public int size(){
        return this.carList.size();
    }
    public Car getCar(int index){
        return carList.get(index);
    }
    public List<Car> getCarList(){
        return carList;
    }
}
