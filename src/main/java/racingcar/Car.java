package racingcar;

public class Car {
    private String name;
    private int driveNum;
    Car(String name, int driveNum) {
        this.name = name;
        this.driveNum = driveNum;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDriveNum() {
        return driveNum;
    }
    private void setDriveNum(int driveNum) {
        this.driveNum = driveNum;
    }
}
