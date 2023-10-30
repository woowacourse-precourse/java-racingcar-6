package racingcar;

public class Car {
    private String name;
    private String distance;

    public Car(String name){
        this.name = name;
        this.distance = "";

    }

    public final String  getName(){
        return this.name;
    }

    public final String getDistance(){
        return this.distance;
    }

    public final void setDistance(String distance){
        this.distance = distance;
    }

}
