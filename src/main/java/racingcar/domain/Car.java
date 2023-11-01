package racingcar.domain;

public class Car {
    private int position = 0;
    private final String name;

    public Car(String name){
        this.name = name;
    }
    public void addDistance(int pos){
        this.position += pos;
    }
    public String getCarName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
}
