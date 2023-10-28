package racingcar;

public class Car {
    private String name;
    private int forwardCount = 0;

    Car (String name) {
        this.name = name;
    }

    void forwardCar(boolean isBiggerThanFour) {
        if(isBiggerThanFour) {
            forwardCount++;
        }
    }

}
