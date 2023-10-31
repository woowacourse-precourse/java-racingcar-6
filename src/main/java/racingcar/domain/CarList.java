package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.service.CarListService.getCarNames;

public class CarList {

    public static List<Car> getCarList(){
        String[] carArray = getCarNames();

        List<Car> carList = new ArrayList<>();

        for(String carName: carArray){
            carList.add(new Car(carName));
        }

        return carList;
    }
}
