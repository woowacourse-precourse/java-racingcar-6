package racingcar;

public class Car {
    private String name;
    private int runCount = 0;

    int moveCount;

    public void setCarName(String name) {
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public void increaseRunCount() {
        runCount++;
    }

    public int getRunCount(){
        return runCount;
    }
}
