package racingcar;

public class Car {
    private String name;
    private int position;
    private static int maxPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
        this.updateMaxPosition();
    }

    private void updateMaxPosition() {
        if (this.position > Car.maxPosition) {
            Car.maxPosition = this.position;
        }
    }

    public boolean isWinner() {
        return this.position == Car.maxPosition;
    }
}
