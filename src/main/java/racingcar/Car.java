package racingcar;

public class Car {
    private Integer currentLocation;
    private String name;

    public Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    public void movingForward() {
        this.currentLocation++;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCurrentLocation() {
        return this.currentLocation;
    }

    public void printCurrentLocation() {
        for (int i = 0; i < currentLocation; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void setName(String name) {
        this.name = name;
    }

}
