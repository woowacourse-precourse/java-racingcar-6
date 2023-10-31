package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> generateCarListWithName(List<String> carNameList){
        List<Car> CarList = new ArrayList<>();
        for (String carName : carNameList) {
            CarList.add(new Car(carName));
        }
        return CarList;
    }
}
