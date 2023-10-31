package racingcar;

public class Car {
    private Integer cuurentLocation;
    private String name;

    public Car(String name) {
        this.name = name;
        this.cuurentLocation = 0;
    }

    public void movingForward() {
        this.cuurentLocation++;
    }

    private boolean judgeForward(Integer number) {
        if (number >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public void stop() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
