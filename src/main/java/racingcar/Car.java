package racingcar;

public class Car {
    private int forwardCnt;
    private String name;

    public Car(String name) {
        this.forwardCnt = 0;
        this.name = name;
    }

    public void countUpGo() {
        forwardCnt += 1;
    }

    public int getForwardCnt() {
        return forwardCnt;
    }

    public String getName() {
        return name;
    }
}
