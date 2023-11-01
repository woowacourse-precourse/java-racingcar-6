package racingcar;

import java.util.*;

public class CarInfoManager {
    public static List<Car> carInfos = new ArrayList<>();
    private static CarInfoManager carInfoManager;

    private CarInfoManager() {
    }

    private static CarInfoManager getInstance() {
        if (carInfoManager == null) {
            carInfoManager = new CarInfoManager();
        }
        return carInfoManager;
    }

    public static void initializeCarInfos(List<String> carNames) {
        getInstance().initialize(carNames);
    }

    public void initialize(List<String> carNames) {
        for (String carName : carNames) {
            carInfos.add(new Car(carName));
        }
    }

    public static void close() {
        if (carInfoManager != null) {
            carInfoManager = null;
        }
        carInfos.clear();
    }

}
