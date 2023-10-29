package racingcar.model;

import java.util.ArrayList;

public class CarObject {
    public final int MOVE_LIMIT_CONDITION = 4;
    public final int CAR_NAME_LIMIT_SIZE = 5;
    public int carOnceMove;
    public int carsSize = 0;
    public int epoch;
    private ArrayList<CarComponent> cars;

    private CarObject() {}

    private static class SingleInstanceHolder {
        private static final CarObject INSTANCE = new CarObject();
    }

    public static CarObject getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}
