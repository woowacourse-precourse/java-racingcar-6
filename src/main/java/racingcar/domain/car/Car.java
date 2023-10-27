package racingcar.domain.car;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void updatePosition(int randomNumber) {
        if (randomNumber > 3) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name);
        result.append(" : ");
        for (int i = 0; i < this.position; i++) {
            result.append("-");
        }
        result.append("\n");
        return result.toString();
    }

    public int getPosition() {
        return this.position;
    }
}
