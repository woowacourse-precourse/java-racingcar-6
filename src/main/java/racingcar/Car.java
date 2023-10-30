package racingcar;

public class Car {
    private final String carName; //자동차 주인 이름
    private int position; //자동차 위치 (점수)

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

    //전진 메서드
    public void moveForward() {
        position++;
    }
    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    //전진 횟수 출력 메서드
    public void showPosition() {
        System.out.print(carName + " : ");
        for (int i=0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
