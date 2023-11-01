package racingcar.domain;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName(){
        return name;
    }

    public int getLocation(){
        return location;
    }

    public void move(){
        location++;
    }


}
