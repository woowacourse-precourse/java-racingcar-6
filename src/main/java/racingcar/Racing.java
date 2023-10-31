package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public void tryOnce() {
        playerList.stream()
                .forEach(car -> car.move());
    }

    public void printResult() {
        playerList.stream()
                .forEach(car -> {
                    System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
                });
        System.out.println("");
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        List<String> winnerNameList = winnerList.stream()
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNameList));
    }
}
