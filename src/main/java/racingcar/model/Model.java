package racingcar.model;

import racingcar.model.Car;
import java.util.List;
import java.util.ArrayList;

public class Model {
    public List<Car> MakeCarList(String[] namesOfCars){
        List<Car> carList = new ArrayList<>();

        for (String nameOfCar : namesOfCars) {
            Car newCar = new Car(nameOfCar);
            carList.add(newCar);
        }
        
        return carList;
    }
}
