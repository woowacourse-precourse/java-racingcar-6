package racingcar.service;

import racingcar.utils.Validation;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class CarService {

    final static Validation validation = new Validation();

    public List<Car> createCars(List<String> nameList){
        List<Car> carList = new ArrayList<>();
        for(String name: nameList){
            carList.add(create(name));
        }
        return carList;
    }

    private Car create(String name){
        validation.checkName(name);
        return new Car(name);
    }
}
