package racingcar.domain;

public class Player {

    private String name;
    private int runCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRunCount() {
        return runCount;
    }

    public void setRunCount() {
        this.runCount++;
    }
}
