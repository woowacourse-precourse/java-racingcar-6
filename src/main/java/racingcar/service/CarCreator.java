package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.Car;

public class CarCreator {



    public static List<Car> createCars(CarName carName, int length){
        List<Car> cars = new ArrayList<>();
        for (String name:carName.rangeCarList){
            cars.add(new Car(name,length));
        }
        return cars;

    }

}
