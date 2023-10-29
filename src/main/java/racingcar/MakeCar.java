package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MakeCar {
    private final List<Car> cars = new ArrayList<Car>();
    public static List<String> CarNameList = new ArrayList<String>();

    public void makeCar(String carNames) {
        CarNameList = List.of(carNames.split(","));
        for (String carName : CarNameList) {
            this.cars.add(new Car(carName));
        }
    }
}
