package racingcar;

public class Car {
    private String name;
    private int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }

    public void move(){
        this.location++;
    }

    public int getLocation(){
        return location;
    }
}
