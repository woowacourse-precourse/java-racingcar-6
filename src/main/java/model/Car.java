package model;

public class Car implements CarInterface {
    private String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void forward() {
        this.location++;
    }

    @Override
    public int getLocation() {
        return location;
    }
}
