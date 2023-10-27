package racingcar.domain;

public class Car {

    private final Name name;
    private int position;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = 0;
    }

    public void move(Integer randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }
}
