package racingcar;

public class Car {
    private String name;
    private int driveNum;
    Car(String name, int driveNum) {
        this.name = name;
        this.driveNum = driveNum;
    }
    public String getName() {
        return name;
    }
    public int getDriveNum() {
        return this.driveNum;
    }
    public void setDriveNum(int driveNum) {
        this.driveNum += driveNum;
    }
}