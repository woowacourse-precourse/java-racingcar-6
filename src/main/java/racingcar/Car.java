package racingcar;

public class Car {
    private final String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public void updatePosition() {
        currentPosition++;
    }

    public boolean isCarPassTheGoal(int round) {
        return round == currentPosition;
    }

    public void printCarName() {
        View view = new View();
        view.print(name);
    }
}
