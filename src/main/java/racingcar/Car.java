package racingcar;

public class Car{
    String carName;
    int mileage;
    Car(String carName){
        setCarName(carName);
        mileage=0;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarName(){
        return carName;
    }

    public void plusMileage(int mileage) {
        this.mileage += mileage;
    }
    public int getMileage() {
        return mileage;
    }
}