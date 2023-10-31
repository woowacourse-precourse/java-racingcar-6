package dto;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        String carInfo = (this.name + " : ");

        for (int i = 0; i < this.distance; i++) {
            carInfo.concat("-");
        }

        return carInfo;
    }
}
