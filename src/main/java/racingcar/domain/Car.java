package racingcar.domain;

public class Car {
    String name;
    public Car(String name){
        if(name.length()>5)
            throw new IllegalArgumentException();
        this.name=name;
    }
}
