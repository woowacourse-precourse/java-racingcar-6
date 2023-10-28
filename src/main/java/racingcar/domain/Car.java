package racingcar.domain;

public class Car {


    private String name;
    private int advanceCount;

    public Car(String carNames) {
        this.name=carNames;
        this.advanceCount=0;
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public int advance(){
        return this.advanceCount++;
    }

    @Override
    public String toString() {
        return name + ": " + '-' * advanceCount  + "\n";
    }
}
