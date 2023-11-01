package racingcar.model;

public class Car {
    private final String name;
    public int advanceNum;

    public Car(String name) {
        this.name = name;
        this.advanceNum = 0;
    }

    public String getName() {
        return name;
    }

    public void increaseAdvanceNum(){
        advanceNum++;
    }

}
