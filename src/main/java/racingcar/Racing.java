package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
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
    }

    public void playRacing() {
        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            tryOnce();
            printResult();
        }

        Integer maxValue = getMaxPosition();

        winnerList = selectWinner(maxValue);
    }

    private Integer getMaxPosition() {
        return playerList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(null);
    }

    private List<Car> selectWinner(Integer maxValue) {
        return playerList.stream()
                .filter(car -> car.getPosition() == maxValue)
                .toList();
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
