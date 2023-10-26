package racingcar.Model;

public class Car {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String LONG_CAR_NAME_MESSAGE = "차량의 이름은 5글자 이하여야 합니다.";
    private String carName;
    private int position;

    public Car(String carName) {
        this.position = 0;
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
