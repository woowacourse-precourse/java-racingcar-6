package racingcar.domain;

public class Player {
    private String name;
    private int winCount;

    Player(String name) {
        name = name;
        winCount = 0;
    }

    public void addWinCount() {
        winCount++;
    }
}
