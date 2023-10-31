package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {

    private Integer tryCount;
    private List<Car> playerList;
    private List<Car> winnerList;

    public Racing(List<Car> playerList, Integer tryCount) {
        this.tryCount = tryCount;
        this.playerList = playerList;
        this.winnerList = new ArrayList<>();
    }

    public void playRacing() {
    }

    private void tryOnce() {
        playerList.stream()
                .forEach(car -> car.move());
    }

    private void printResult() {
    }

    public void printWinner() {
    }
}
