package racingcar.model;

public class Car {
    private final String carName;
    private int carAdvances;

    public Car(final String carName, int carAdvances){
        this.carName = carName;
        this.carAdvances = carAdvances;
    }

    public String getCarName(){
        return this.carName;
    }

    public int getCarAdvances(){
        return this.carAdvances;
    }
}
