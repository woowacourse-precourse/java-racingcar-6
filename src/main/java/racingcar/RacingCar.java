package racingcar;

public class RacingCar {
    private String carName;
    private int carMovingNum = 0;

    public RacingCar(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    public int getCarMovingNum(){
        return carMovingNum;
    }

    public void oneStepMovingCar(){
        carMovingNum++;
    }
}
