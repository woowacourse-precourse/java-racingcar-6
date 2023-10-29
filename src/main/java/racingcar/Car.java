package racingcar;

public class Car {
    private String name;
    private int forward = 0;
    public Car(String name){
        this.name = name;
    }
    public void moveForward(){
        forward++;
    }
    public int getForward(){
        return forward;
    }
    public String getName(){
        return name;
    }
}
