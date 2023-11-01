package racingcar.model;

public class Car {
    private String carName;
    private Integer advanceCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, Integer advanceCount) {
        this.carName = carName;
        this.advanceCount = advanceCount;
    }

    public void advanceIfRandomIsAtLeastFour(Integer randomNum){
        if(randomNum >= 4 ){
            this.advanceCount++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public Integer getAdvanceCount() {
        return advanceCount;
    }
}
