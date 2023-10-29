package racingcar;

import java.util.ArrayList;
import java.util.Collection;

public class GameHost {

    Collection<Car> carList;

    private GameHost(Collection<Car> cars){
        this.carList = cars;
    }
    public void playOneTurn() {

    }

    public static GameHost addCars(Collection<Car> cars) {
        return new GameHost(cars);
    }

}
