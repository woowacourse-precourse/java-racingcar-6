package racingcar.service;

import racingcar.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverService {

    public void move(int number, Driver driver) {
        if (number >= 4) {
            driver.move();
        }
    }

    public List<String> getWinnerList(List<Driver> driverList) {
        List<String> winnerList = new ArrayList<>();
        checkWinner(driverList, winnerList);
        return winnerList;
    }

    private void checkWinner(List<Driver> driverList, List<String> winnerList) {
        int winnerScore = 0;
        for (Driver driver : driverList) {
            String driverName = driver.getName();
            int driverMoveCount = driver.getMoveCount();

            if (winnerScore < driverMoveCount) {
                winnerList.clear();
                winnerList.add(driverName);
                winnerScore = driverMoveCount;
            } else if (winnerScore == driver.getMoveCount()) {
                winnerList.add(driverName);
                winnerScore = driverMoveCount;
            }
        }
    }

}
