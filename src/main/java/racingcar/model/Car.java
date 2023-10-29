package racingcar.model;

public class Car {
    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 4;
    private final int STANDARD_VALUE = 4;

    private String name;
    private int distance = 0;

    public Car() {
    }

    public Car(String name) {
        lengthValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }

    public void run(int number){
        if(isMove(number)){
            this.distance++;
        }
    }

    private boolean isMove (int number){
        return number >= STANDARD_VALUE;
    }

    private void lengthValidation(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        } else if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
