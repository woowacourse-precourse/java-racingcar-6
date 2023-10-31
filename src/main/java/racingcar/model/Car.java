package racingcar.model;

public class Car {

    private static final int GOOD_TO_RUN = 4;

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void run(int isGoodToRun) {
        if (isGoodToRun >= GOOD_TO_RUN) {
            position.add();
        }
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }
}