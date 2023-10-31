package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    final List<Car> carList = new ArrayList<>();
    int round = 0;

    public CarList(int round, List<String> carNameSplit) {
        this.round = round;
        for(String carName : carNameSplit) {
            this.carList.add(new Car(carName));
        }
    }

    public int getRound() {
        return this.round;
    }
}
