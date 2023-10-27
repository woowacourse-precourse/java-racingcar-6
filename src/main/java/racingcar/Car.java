package racingcar;

public class Car {
    String name;

    public Car(){}
    public Car(String name){
        validName(name);
        this.name = name;
    }
    public void validName(String name){
        if(name.length()>5) throw new IllegalArgumentException("5글자 이하만 가능");
    }
}
