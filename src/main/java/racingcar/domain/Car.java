package racingcar.domain;

public class Car {

    private String name;
    private int distance;
    private static final int LIMIT_NAME_LENGTH = 5;

    public Car(String name) {
        if(name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int movesForward(){
        distance++;
        return distance;
    }
}
