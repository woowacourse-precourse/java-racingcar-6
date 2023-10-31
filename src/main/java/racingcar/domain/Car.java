package racingcar.domain;

public class Car {

    private static final Integer initialDistance = 0;
    private String name;
    private Integer distance;

    public Car(String name){
        this.name = name;
        this.distance = initialDistance;
    }

    public String getName(){
        return name;
    }

    public Integer getDistance(){
        return distance;
    }
}
