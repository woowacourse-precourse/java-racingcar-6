package racingcar.model;

public class Car {
    private final Name carName;
    private int carAdvances;

    public Car(final Name carName) {
        this.carName = carName;
        this.carAdvances = 0;
    }

    public void addAdvances(){
        this.carAdvances++;
    }

    public String getCarName(){
        return this.carName.getName();
    }

    public int getCarAdvances(){
        return this.carAdvances;
    }
}
