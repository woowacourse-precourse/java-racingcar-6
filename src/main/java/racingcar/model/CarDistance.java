package racingcar.model;

import java.util.List;

public class CarDistance {
    private List<Integer> carDistance;

    public CarDistance(List<Integer> playerDistance) {
        this.carDistance = playerDistance;
    }

    public CarDistance makePlayerDistance(List<Integer> playerDistance) {
        return new CarDistance(playerDistance);
    }

    public int getDistanceOf(int index) {
        return carDistance.get(index);
    }

    public List<Integer> getPlayerDistance() {
        return carDistance;
    }

    public int getSize() {
        return carDistance.size();
    }

    public void setStartPoint() {
        for (int i = 0; i < carDistance.size(); i++) {
            carDistance.add(i, 0);
        }
    }

    public void setDistance(int index) {
        int distance = carDistance.get(index);
        carDistance.set(index, distance + 1);
    }
}
