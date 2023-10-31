package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하만 가능합니다.";
    private static final int MOVING_FORWARD = 4;

    private String carName;
    private Position position;

    Car(String carName) {
        validate(carName);
        this.carName = carName;
        this.position = new Position();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            position.shift(1);
        }
    }

    public void printCarNameAndPosition() {
        System.out.println(carName + " : " + "-".repeat(position.getPosition()));
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }

    private void validate(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }
}
