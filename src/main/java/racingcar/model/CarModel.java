package racingcar.model;


public class CarModel {

    private static final int FORWARD_NUMBER = 4;
    private static final int MIN_NAME_LENGTH = 5;
    private final String name;
    private int location;

    public CarModel(String carName) {
        nameLengthValidation(carName);
        this.name = carName;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            this.location++;
        }
    }

    private void nameLengthValidation(String carName) {
        if (!(carName.length() <= MIN_NAME_LENGTH)) {
            System.out.println("자동차 이름은 5 자 초과할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
