package racingcar;

public class Car{
    String carName;
    int winCount;
    Car(String carName){
        setCarName(carName);
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
}