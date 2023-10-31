package racingcar;

public class Car {
    private Integer cuurentLocation;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void movingForward() {
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
