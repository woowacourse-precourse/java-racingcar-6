package racingcar.business;

public class Car {

    private static final int FORWARD_DICISION_NUMBER = 4;

    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar(Integer randomNumber) {
        if (randomNumber.intValue() >= FORWARD_DICISION_NUMBER) {
            forward();
        }
    }

    private void forward() {
        distance ++;
    }

}
