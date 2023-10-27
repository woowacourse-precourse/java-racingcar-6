package racingcar.domain;

public class Car {
    private final String name;
    private int location=0;

    public Car(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void incLocation(){
        location++;
    }

    public int getLocation(){
        return location;
    }
}
