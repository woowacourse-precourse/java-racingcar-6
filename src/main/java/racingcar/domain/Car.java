package racingcar.domain;

public class Car {
    private final String name;
    private int location = 0;

    public Car(String name){
        this.name = name;
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
