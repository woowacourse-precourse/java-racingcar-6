package racingcar;

public class Car {
    private String carName;
    private int gameResult = 0;
    public Car(String carName, int gameResult){
        this.carName = carName;
        this.gameResult = gameResult;
    }

    public String getCarName(){
        return this.carName;
    }

    public int getGameResult(){
        return this.gameResult;
    }

    public void setGameResult(){
        this.gameResult++;
    }
}
