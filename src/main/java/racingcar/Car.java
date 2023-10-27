package racingcar;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        // 이름 검사, 이름이 잘못되면 IllegalArgumentException 발생
        CarNameValidator carNameValidator = new CarNameValidator();
        try {
            carNameValidator.isValidName(carName);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        this.carName = carName;
        this.position = 0;
    }
    public void moveForward() {
        position++;
    }
    public String getCarName() {
        return carName;
    }

    public void showPosition() {
        System.out.print(carName + " : ");
        for (int i=0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
