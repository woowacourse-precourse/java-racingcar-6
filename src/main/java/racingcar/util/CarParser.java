package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarParser {
    public List<Car> stringToCarList(String string){
        List<Car> carList = new ArrayList<>();
        String[] stringArr = string.split(",");

        for(String str : stringArr){
            Car car = new Car();
            car.createCar(str);
            carList.add(car);
        }
        return carList;
    }
}
