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
    public void display() {
        System.out.print(this.name + " : "+this.distanceImage+"\n");
    }
    public int compareMaxDistance(int maxDistance){
        if(this.distance > maxDistance){
            return this.distance;
        }
        return 0;
    }
    public String addWinner(int maxDistance,String winners){
        if(this.distance == maxDistance){
            return winners+" "+name+",";
        }
        return winners;
    }
}
