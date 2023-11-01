package racingcar.domain;

public class Car {
    public String name="";
    public int distanceNumber=0;
    public Car(String name){
        this.name = name;
    }
    public void go(){
        this.distanceNumber++;
    }
}
