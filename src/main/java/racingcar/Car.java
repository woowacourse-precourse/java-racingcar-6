package racingcar;

public class Car {
    private String name;
    private int forward;
    private int winCount;

    public Car (String name){
        this.name = name;
        this.forward = 0;
        this.winCount = 0;
    }

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
