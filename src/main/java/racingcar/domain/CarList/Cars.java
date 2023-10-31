package racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> carList = new ArrayList<>();

    public void setCarName(List<String> carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

}
