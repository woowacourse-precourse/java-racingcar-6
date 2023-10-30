package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarListInvalidator {

    public static void validate(List<Car> carList){
        if(isCarAlone(carList) || isCarDuplicated(carList)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarAlone(List<Car> carList){
        return carList.size() <= 1;
    }

    private static boolean isCarDuplicated(List<Car> carList){
        Set<Car> cars = new HashSet<>(carList);
        return cars.size() == carList.size();
    }
}
