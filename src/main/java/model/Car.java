package model;

public class Car {
    private String name;
    private int runCount = 0;

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
