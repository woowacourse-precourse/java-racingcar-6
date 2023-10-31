package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    final List<Car> carList = new ArrayList<>();

    public CarList(List<String> carNameSplit) {
        for(String carName : carNameSplit){
            this.carList.add(new Car(carName));
        }
    }
}
