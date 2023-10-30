package racingcar.domain;

import java.util.List;

public class GameManager {
    private static int attemptNumber;
    private static List<Car> carImplList;

    private GameManager() {
    }

    public static int getAttemptNumber() {
        return attemptNumber;
    }

    public static void setAttemptNumber(int attemptNumber) {
        GameManager.attemptNumber = attemptNumber;
    }

    public static List<Car> getCarImplList() {
        return carImplList;
    }

    public static void setCarImplList(List<Car> carImplList) {
        GameManager.carImplList = carImplList;
    }


}
