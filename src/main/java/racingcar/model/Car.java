package racingcar.model;

public class Car {
    private final String carName;
    private int carAdvances;

    public Car(final String carName) {
        this.carName = carName;
        this.carAdvances = 0;
    }

    public void addAdvances(){
        this.carAdvances++;
    }

    public String getCarName(){
        return this.carName;
    }

    public int getCarAdvances(){
        return this.carAdvances;
    }
}
