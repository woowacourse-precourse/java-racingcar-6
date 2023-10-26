package racingcar.domain;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    // TODO: View와 의존적인 코드가 존재하는 것이 옳은지 생각해보기
    private static final String CAR_INFO_FORMAT = "%s : %s";
    private static final String POSITION_EXPRESS_CHARACTER = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this.validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
        }
    }

    public void drive() {
        this.position += 1;
    }

    private String expressPosition() {
        return POSITION_EXPRESS_CHARACTER.repeat(this.position);
    }

    @Override
    public String toString() {
        String position = expressPosition();
        return String.format(CAR_INFO_FORMAT, this.name, position);
    }
}
