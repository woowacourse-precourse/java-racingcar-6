package racingcar.model;

public class Car {
    private static final int MOVE = 1;
    private static final String MOVE_FORWARD = "-";
    private String name;
    private int carState;

    public Car(String name){
        this.name = name;
        carState = 0;
    }

    public String getName(){
        return name;
    }

    public int getCarState(){
        return carState;
    }

    public void setCarState(){
        carState = carState + MOVE;
    }
}
