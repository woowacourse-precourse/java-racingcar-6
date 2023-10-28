package racingcar;

public class Car {

    private int location;
    private String name;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public int move(int randomNumber) {
        if(randomNumber > 0 && randomNumber < 4) {
            location++;
        }
        return location;
    }

    public int getCurrentLocation() {
        return location;
    }
}
