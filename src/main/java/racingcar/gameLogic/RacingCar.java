package racingcar.gameLogic;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public List<Driver> drivers;
    private User user = new User();
    int tryCount;

    public void init() {
        drivers = new ArrayList<>();
        tryCount = 0;
    }

    public void run() {
    }

    public void setDrivers(List<String> carNames) {
        for (String carName : carNames) {
            drivers.add(new Driver(carName));
        }
    }

}
