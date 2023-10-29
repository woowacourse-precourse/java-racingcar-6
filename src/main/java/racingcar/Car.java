package racingcar;

public class Car {
    private String name = "";
    private int forward = 0;
    private int winCount = 0;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForward() {
        return this.forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
}
