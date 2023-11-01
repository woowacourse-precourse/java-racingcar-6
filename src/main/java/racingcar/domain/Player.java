package racingcar.domain;

public class Player {
    public String name;
    public int winCount;

    public Player(String name) {
        this.name = name;
        this.winCount = 0;
    }

    public void addWinCount() {
        winCount++;
    }
}
