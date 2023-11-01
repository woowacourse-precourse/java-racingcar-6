package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<String> winnerList;
    private List<Car> carList;
    private int raceCount;

    public Racing(List<Car> carList, int raceCount) {
        this.winnerList = new ArrayList<>();
        this.carList = carList;
        this.raceCount = raceCount;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public void addWinnerList(String winnerName) {
        this.winnerList.add(winnerName);
    }
}
