package racingcar.domain;

public class Car {
    private int position = 0;
    private final String name;

    public Car(String name){
        this.name = name;
    }
    public void increasePosition(int distance){
        this.position += distance;
    }
    public String getCarName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
}
