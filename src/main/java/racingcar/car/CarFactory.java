package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> generateCarListWithName(List<String> carNameList){
        List<Car> CarList = new ArrayList<>();
        for (String carName : carNameList) {
            CarList.add(new Car(carName));
        }
        return CarList;
    }
}
