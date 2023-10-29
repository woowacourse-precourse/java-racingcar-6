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

    public int findMaxPosition() {
        int maxPosition = 0;

        for (Integer carPosition : carPosition) {
            if (carPosition > maxPosition) {
                maxPosition = carPosition;
            }
        }
        return maxPosition;
    }

    public List<Integer> findWinnerIndex(int maxPosition) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<this.carPosition.size(); i++) {
            if (this.carPosition.get(i) == maxPosition) {
                result.add(i);
            }
        }
        return result;
    }

    public int getCarSize() {
        return this.carPosition.size();
    }
}
