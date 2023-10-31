package racingcar;

public class Car {


    private String name;

    private int currentPlace;

    public Car(String name) {
        this.name = name;
        this.currentPlace = 0;
    }
    public String getName() {
        return this.name;
    }
    public int getCurrentPlace() {
        return this.currentPlace;
    }

    public void plusCurrentPlace() {
        currentPlace = currentPlace + 1;
    }

}
