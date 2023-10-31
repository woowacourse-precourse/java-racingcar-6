package racingcar.Domain;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MIN_VALUE_FOR_MOVE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarNameIsNullOrEmpty(name);
        validateCarNameLength(name);
        this.name = name;
    }
    public static Car of(String name) {
        return new Car(name);
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void move(int value) {
        if (value >= MIN_VALUE_FOR_MOVE) {
            position ++;
        }
    }

    // 검증
    public static void validateCarNameIsNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 null 혹은 빈 문자열일 수 없습니다.");
        }
    }
    public static void validateCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH || name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
