package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public Cars(){
    }
    public static List<Car> buildCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName: carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }


}
