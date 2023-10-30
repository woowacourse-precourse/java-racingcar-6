package racingcar.domain;

import java.util.List;

public class GameManager {
    private static List<Car> carImplList;

    private GameManager() {
    }

    public static List<Car> getCarImplList() {
        return carImplList;
    }

    public static void setCarImplList(List<Car> carImplList) {
        GameManager.carImplList = carImplList;
    }


}
