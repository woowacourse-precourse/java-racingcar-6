package racingcar;

public class Car {
    String name;
    boolean isForward;
    int moveCount;


    Car(String name){
        this.name = name;
        this.isForward = false;
        this.moveCount = 0;
    }
}
