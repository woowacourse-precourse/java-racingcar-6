package racingcar.Domain;

import java.util.List;

public class GameStatus {
    private int goalRound;
    private int maxCount;
    private List<Car> carList;

    public int getGoalRound() {
        return goalRound;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setGoalRound(int goalRound) {
        this.goalRound = goalRound;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = Math.max(this.maxCount, maxCount);
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
