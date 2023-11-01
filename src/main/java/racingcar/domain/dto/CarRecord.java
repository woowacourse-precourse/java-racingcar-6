package racingcar.domain.dto;

public class CarRecord {

    private String carName;
    private int numberOfStep;

    public CarRecord(String carName, int numberOfStep){
        this.carName = carName;
        this.numberOfStep = numberOfStep;
    }

    public String getCarName() {
        return carName;
    }

    public int getNumberOfStep() {
        return this.numberOfStep;
    }
}
