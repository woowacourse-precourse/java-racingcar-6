package racingcar;

public class Car {
    private static final int MOVE_CONDITION = 4;

    GameManager gameManager = new GameManager();

    private final String carName;
    private int position;

    private Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car from(String carName, int position){
        return new Car(carName, position);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (gameManager.createRandomNumber() >= MOVE_CONDITION) {
            position++;
        }
    }
}
