package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private static final int MINIMUM_NUM_TO_MOVE = 4;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int generatedRandomNum) {
        if (generatedRandomNum >= MINIMUM_NUM_TO_MOVE) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
