package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static List<Car> carImplList = new ArrayList<Car>();

    private GameManager() {
    }

    public static List<Car> getCarImplList() {
        return carImplList;
    }

    public static void addCarImpl(Car carImpl) {
        carImplList.add(carImpl);
    }


}
