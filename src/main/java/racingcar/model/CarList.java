package racingcar.model;

import java.util.List;

public class CarList {
    public static List<Car> carList;
    public CarList(List<String> nameList){
        for (String name : nameList) {
            carList.add(new Car(name));
        }
    }
    public static void carListMove() {
        for (Car car : carList) {
            car.randomMove();
        }
    }

}
