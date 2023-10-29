package racingcar.Model;

public class Car {
    private final String name;

    private int carPosition;

    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void forwardCarPosition(){
        carPosition++;
    }

    public int getCarPosition(){
        return this.carPosition;
    }
}
