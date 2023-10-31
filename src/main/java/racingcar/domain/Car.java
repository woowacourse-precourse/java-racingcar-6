package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(){
        this.distance++;
    }

    public String getCarInfo(){
        StringBuilder result = new StringBuilder(this.name + " : ");
        for(int i=0; i<this.distance; i++){
            result.append("-");
        }
        return result.toString();
    }
}
