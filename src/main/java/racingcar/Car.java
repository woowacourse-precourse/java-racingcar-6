package racingcar;

public class Car {
    final private String name;
    private int forward = 0;

    Car(String name) {
        this.name = name;
    }

    void goForward(boolean flag){
        if (flag)
            this.forward++;
    }
}
