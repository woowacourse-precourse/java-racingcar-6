package racingcar.domain.car;

import java.util.List;
import racingcar.domain.Movable;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void oneRoundContinue(Movable movable){
        for(Car car : carList){
            car.goForward(movable);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
