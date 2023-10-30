package racingcar.domain.car;

import java.util.List;
import racingcar.domain.Movable;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void oneTurnContinue(Movable movable){
        for(Car car : carList){
            car.goForward(movable);
        }
    }
}
