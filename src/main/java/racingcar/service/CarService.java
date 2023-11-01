package racingcar.service;

import racingcar.util.constant.message.ErrorMessage;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.constant.Number.*;

public class CarService {

    public List<Car> createCars(List<String> nameList){
        List<Car> carList = new ArrayList<>();
        for(String name: nameList){
            carList.add(create(name));
        }
        return carList;
    }

    private Car create(String name){
        checkName(name);
        return new Car(name);
    }
    private void checkName(String name){
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LONG.getMessage());
        }
    }
}
