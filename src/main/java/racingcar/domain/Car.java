package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name){
        this.name =name;
        distance = 0;
    }

    public void move(){
        distance++;
    }
    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
