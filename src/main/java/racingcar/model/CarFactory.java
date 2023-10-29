package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final List<Car> carList;

    public CarFactory(List<String> carNames){
        this.carList = makeCars(carNames);
    }

    private List<Car> makeCars(List<String> carNames){
        List<Car> carList = new ArrayList<>();
        for(String car : carNames){
            carList.add(new Car(car));
        }

        return carList;
    }

    public List<Car> getCarList(){
        return carList;
    }
}
