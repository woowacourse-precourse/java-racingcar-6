package racingcar.model;

public class Car {

    private String carName;
    private int carLocation;

    public int moveForward(int carNumber) {
        if (carNumber >= 4) {
            carLocation++;
        }
        return carLocation;
    }


}
