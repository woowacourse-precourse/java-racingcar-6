package racingcar;

public class Car {
    private String carName;
    private String carPath;
    public void makeCar(String carName){
        this.carName = carName;
        this.carPath = "";
    }
    public void movingCar(){
        carPath += "-";
    }
    public String getCarName(){
        return carName;
    }

    public String getCarPath(){
        return carPath;
    }
}
