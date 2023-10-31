package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private Integer tryCount;
    private List<Car> playerList;
    private List<Car> winnerList;

    public Racing(List<Car> playerList, Integer tryCount) {
        this.tryCount = tryCount;
        this.playerList = playerList;
        this.winnerList = new ArrayList<>();
    }

    public void trySeveral(List<Car> carList, int tryCount) {
    }

    public void tryOnce(List<Car> carList) {
    }

    public void printResult(List<Car> carList) {
    }

    public void printWinner(List<Car> winnerList) {
    }
}
