package racingcar.domain;

public class Car {
    private String name;
    private int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }
    public void go(){
        this.location++;
    }
    public String getName(){
        return this.name;
    }
    public int getLocation(){
        return this.location;
    }
    public String toString(){
        return this.name + " : " + "-".repeat(this.location);
    }
}
