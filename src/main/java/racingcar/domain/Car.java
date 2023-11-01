package racingcar.domain;


public class Car {

    public static final String ROAD_MARK = "-";
    private final String name;

    private String mileage;

    public Car(String name) {
        this.name = name;
        this.mileage = "";
    }

    public String getName() {
        return this.name;
    }

    public String getMileage() {
        return this.mileage;
    }

    public void addDistance() {
        this.mileage += ROAD_MARK;
    }

    public String showCarInfo() {
        return name + " " + ":" + " " + mileage;
    }
}
