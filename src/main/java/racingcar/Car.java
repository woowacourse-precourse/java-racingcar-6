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

    public boolean judgeForward(Integer number) {
        if (number >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
