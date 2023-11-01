package racingcar.model;

public class Car {
    final String name;
    Integer location;

    public Car(String name, Integer location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }

    public void increaseCarLocation() {
        this.location += 1;
    }

}
