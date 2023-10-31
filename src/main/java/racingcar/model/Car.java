package racingcar.model;

public class Car {
    private String name;
    private Integer advanceCount;

    public Car(String name) {
        this.name = name;
        this.advanceCount = 0;
    }

    public Integer getAdvanceCount() {
        return advanceCount;
    }

    public void advance(int randomNumber) {
        if(randomNumber >= 4) {
            this.advanceCount++;
        }
    }
}
