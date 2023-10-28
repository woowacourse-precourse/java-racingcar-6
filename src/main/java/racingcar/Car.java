package racingcar;

public class Car {
    private String name;
    private StringBuilder status;
    private Judgment judgment;
    private static final char MOVE = '-';

    public Car(String name) {
        this.name = name;
        this.status = new StringBuilder();
        this.judgment = new Judgment();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status.toString();
    }

    public void move(int randomNumber) {
        if (judgment.isMoveOrStop(randomNumber)) {
            status.append(MOVE);
        }
    }
}