package racingcar.model;

public class Car implements Comparable<Car> {

    private static final String BETWEEN_NAME_AND_POSITION = " : ";
    private static final String POSITION_UNIT = "-";
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

    @Override
    public int compareTo(Car compareCar) {
        return position.value() - compareCar.getPosition();
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }
}