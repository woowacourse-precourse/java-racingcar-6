package racingcar.domain;

public class Car {
    private final String carName;
    private int process;

    public Car(String carName) {
        this.carName = carName;
        this.process = 0;
    }

    public Car(String carName, int process) {
        this.carName = carName;
        this.process = process;
    }

    public int getProcess(){
        return process;
    }
    public String getCarName(){
        return carName;
    }

    public void increaseProcess(){
        process++;
    }
}
