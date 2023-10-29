package racingcar.service;

import java.util.List;
import racingcar.config.Config;
import racingcar.model.Car;
import racingcar.utils.RandomUtil;

public class CarService {
    private int forwardNum;

    public void carForward(List<Car> carList) {
        for (int j = 0; j < carList.size(); j++) {
            forwardNum = RandomUtil.getRandomNumber();
            if (forwardNum >= Config.SET_VALUE) {
                Car selectCar = carList.get(j);
                selectCar.increaseForward();
            }
        }
    }
}
