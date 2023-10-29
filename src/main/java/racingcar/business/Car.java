package racingcar.business;

public class Car {

    private static final int FORWARD_DECISION_NUMBER = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void moveCar(Integer randomNumber) {

        if(!isValidRangeNumber(randomNumber)) {
            throw new IllegalArgumentException("입력된 숫자의 범위가 일치하지 않습니다.");
        }

        if (randomNumber.intValue() >= FORWARD_DECISION_NUMBER) {
            forward();
        }

    }

    private void forward() {
        distance ++;
    }

    private boolean isValidRangeNumber(Integer number) {
        return number >= MIN_RANGE && number <= MAX_RANGE;
    }

}
