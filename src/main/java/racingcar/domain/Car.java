package racingcar.domain;

public class Car {
    private final String name;
    private int location;

    public Car(String name, int location){
        this.name = name;
        this.location = location;
    }
    public void moveCar(int moveNum){
        location += moveNum;
    }
    public String getCarName(){
        return name;
    }
    public int getCarLocation(){
        return location;
    }
}
