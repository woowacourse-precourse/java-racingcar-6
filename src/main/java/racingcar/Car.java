package racingcar;

public class Car {
    private String carName;
    private int forwardCnt;

    public Car(String carName) {
        this.carName = carName;
        this.forwardCnt = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getForwardCnt() {
        return forwardCnt;
    }

    public void setForwardCnt(int forwardCnt) {
        this.forwardCnt = forwardCnt;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            forwardCnt++;
        }
    }

    @Override
    public String toString() {
        return carName + " : " + "-".repeat(forwardCnt);
    }
}
