package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarDistance {
    private List<Integer> carDistance;

    private CarDistance(List<Integer> carDistance) {
        this.carDistance = carDistance;
    }

    public static CarDistance makeCarDistance() {
        List<Integer> distance = new ArrayList<>();
        return new CarDistance(distance);
    }

    public void setStartPoint(int index) {
        for (int i = 0; i < index; i++) {
            carDistance.add(i, 0);
        }
    }

    public int getDistanceOf(int index) {
        return carDistance.get(index);
    }

    public List<Integer> getCarDistance() {
        return carDistance;
    }

    public void setDistance(int index) {
        int distance = carDistance.get(index);
        carDistance.set(index, distance + 1);
    }
}
