package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ErrorMessage = "경주할 자동차의 이름은 5자 이하로 작성해 주세요.";
    private final String car;

    public Car(String car) {
        this.car = car;
    }

    public static Car makeCar(String splitInput) {
        validateCar(splitInput);
        return new Car(splitInput);
    }

    private static void validateCar(String splitInput) {
        if (splitInput.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }
}
