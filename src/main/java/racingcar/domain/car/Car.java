package racingcar.domain.car;

public class Car implements Comparable<Car> {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_NUMBER_TO_MOVE = 4;

    // TODO: View와 명시적으로 남아있는 의존성을 분리하기
    private static final String CAR_INFO_FORMAT = "%s : %s\n";
    private static final String POSITION_EXPRESS_CHARACTER = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this.validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 까지만 허용됨");
        }
    }

    public void tryToMove(int number) {
        if (number > MIN_NUMBER_TO_MOVE) {
            this.position += 1;
        }
    }

    private String expressPosition() {
        return POSITION_EXPRESS_CHARACTER.repeat(this.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String position = this.expressPosition();
        return String.format(CAR_INFO_FORMAT, this.name, position);
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
