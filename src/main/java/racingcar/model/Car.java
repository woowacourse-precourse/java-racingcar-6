package racingcar.model;

public class Car {
    private String name; //name of the car
    private Integer location; //location of the car means the number of '-'

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public void moveForward(){
        this.location++;
    }
}
