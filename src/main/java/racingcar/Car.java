package racingcar;

public class Car {

    private final String name;
    private int forward = 0;
    public Car(String name) {
        this.name = name;
    }

    public void setForward(int forward){
        this.forward += forward;
    }

    public int getForward(){
        return this.forward;
    }

    public String getName(){
        return this.name;
    }
}
