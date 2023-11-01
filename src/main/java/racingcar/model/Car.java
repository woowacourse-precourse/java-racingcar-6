package racingcar.model;

public class Car {

    private String name;

    private int advanceCount;

    public Car(String name) {
        this.name = name;
        this.advanceCount = 0;
    }

    public void advance(int randomNumber) {
        if(randomNumber >= 4) {
            this.advanceCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

}
