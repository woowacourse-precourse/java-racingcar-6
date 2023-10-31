package racingcar.model;

public class Car {
    public String name;
    public int position;

    public Car(String name){
        this.name=name;
    }

    public void move(){
        ++position;
    }
}
