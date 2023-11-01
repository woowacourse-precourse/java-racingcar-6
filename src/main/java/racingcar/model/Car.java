package racingcar.model;

public class Car {
    private String name;
    private int location;
    private String locationSymbol;

    public Car(String name) {
        this.name = name;
        this.locationSymbol = "";
    }

    public void moveForward() {
        this.location++;
        this.locationSymbol += "-";
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getLocationSymbol() {
        return this.locationSymbol;
    }

}
