package racingcar;

public class Car {
    private String carName;
    private String carPath;
    private int movingCount;

    public void makeCar(String carName){
        this.carName = carName;
        this.carPath = "";
        this.movingCount = 0;
    }

    public void carInfoUpdate(){
        this.carPath += "-";
        this.movingCount++;
    }

    public String getCarName(){
        return this.carName;
    }

    public String getCarPath(){
        return this.carPath;
    }

    public int getMovingCount(){
        return this.movingCount;
    }
}
