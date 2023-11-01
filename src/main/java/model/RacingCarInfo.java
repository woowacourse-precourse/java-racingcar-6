package model;

public class RacingCarInfo {
    public final String name;
    public final int index;
    public int moveCount;

    public RacingCarInfo(String name, int index) {
        this.name = name;
        this.index = index;
        moveCount = 0;
    }
}