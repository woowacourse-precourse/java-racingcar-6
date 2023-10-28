package racingcar.domain;

public class Car {


    private String name;
    private int advanceCount;

    public Car(String carNames, int i) {
        this.name=carNames;
        this.advanceCount=i;
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }
}
