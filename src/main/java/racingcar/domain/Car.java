package racingcar.domain;

public class Car {
    String name;
    String result;

    public Car(String name) {
        this.name = name;
        this.result = name + " : ";
    }

    public void addResult(){
        result += "-";
    }
}
