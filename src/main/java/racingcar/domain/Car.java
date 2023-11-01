package racingcar.domain;

public class Car {
    String carName;
    int goCount;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getGoCount() {
        return goCount;
    }

    public void setGoCount(int goCount) {
        this.goCount = goCount;
    }

    public void upGoCount(){
        this.goCount = goCount+1;
    }
}
