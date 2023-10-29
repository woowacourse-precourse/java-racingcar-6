package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {

    private static final int CAR_START_POSITION = 0;
    private static final int CAR_MOVE_STEP = 1;

    private List<String> carName = new ArrayList<>();
    private List<Integer> carPosition = new ArrayList<>();

    public void initCar(List<String> carlist) {
        for (String element : carlist) {
            this.carName.add(element);
            this.carPosition.add(CAR_START_POSITION);
        }
    }

    public List<String> getCarName() {
        return this.carName;
    }

    public List<Integer> getCarPosition() {
        return this.carPosition;
    }

    public void carMove(int move) {
        this.carPosition.set(move, this.carPosition.get(move) + CAR_MOVE_STEP);
    }

}
