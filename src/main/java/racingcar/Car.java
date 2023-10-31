package racingcar;

public class Car {
    static GameManager gameManager = new GameManager();

    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
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
