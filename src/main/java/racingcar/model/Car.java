package racingcar.model;

public class Car {
    public String name;
    public int position;

    public void Car(String name){
        this.name=name;
        position=0;
    }

    public void move(){
        ++position;
    }
}
