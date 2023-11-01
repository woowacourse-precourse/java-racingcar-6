package racingcar;

public class Car {
    GameManager gameManager = new GameManager();
    private final String carName;
    private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (gameManager.createRandomNumber() >= 4) {
            position++;
        }
    }
}
