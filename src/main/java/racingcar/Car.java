package racingcar;

public class Car {

    private int location;
    private String name;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public int move(int randomNumber) {
        if(randomNumber > 3 && randomNumber < 10) {
            location++;
        }
        return location;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return location;
    }
}
