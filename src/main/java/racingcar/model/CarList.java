package racingcar.model;

import java.util.List;

public class CarList {
    List<Car> carList;
    CarList(List<String> nameList){
        for (String name : nameList) {
            carList.add(new Car(name));
        }
    }

}
