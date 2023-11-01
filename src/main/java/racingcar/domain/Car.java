package racingcar.domain;

public class Car {
    private String name="";
    private int distance=0;
    private String distanceImage="";
    public Car(String name){
        this.name = name;
    }
    public void go(){
        this.distance++;
        this.distanceImage+="-";
    }
    public String getName(){
        return name;
    }
    public int getDistance(){
        return distance;
    }

    public void display() {
        System.out.print(this.name + " : "+this.distanceImage+"\n");
    }
}
