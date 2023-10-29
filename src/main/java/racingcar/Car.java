package racingcar;

public class Car {
    private static final int MAX_LENGTH_OF_NAME = 5;
    String name;

    private Car(String carName) {
        name = carName;
    }

    public static Car of(String carName) {
        if(carName.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH_OF_NAME + "글자 이하로 입력해주세요. (" + carName + " : " + carName.length() + "글자)");
        }
        return new Car(carName);
    }
}
