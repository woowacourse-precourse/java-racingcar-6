package racingcar.domain;

public class Car {

    private String name;
    private int advancedNum;

    public Car(int i, String carName) {
        advancedNum = i;
        name = carName;
    }

    public void plus() {
        advancedNum++;
    }

    public String findName() {
        return name;
    }

    public int findAdvanceNum() {
        return advancedNum;
    }
}