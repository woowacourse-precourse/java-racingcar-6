package racingcar.model;

public class Car {
    String name;
    int result;

    public Car(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public void updateResult(int count){
        this.result = result + count;
    }
}
