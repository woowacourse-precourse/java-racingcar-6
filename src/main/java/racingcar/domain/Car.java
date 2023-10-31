package racingcar.domain;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void printLocation(Car car) {
        int location = car.getLocation();
        String name = car.getName();

        System.out.println(name + " : " + "-".repeat(location));
    }

    public void setLocation() {
        this.location += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }
}
