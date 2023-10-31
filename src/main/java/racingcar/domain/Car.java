package racingcar.domain;

public class Car {
    private String name;
    private int location;

    public static final Integer MIN_NUMBER_TO_MOVE = 4;
    public static final Integer MOVE_DISTANCE = 1;
    public static final Integer START_POSITION = 0;

    public Car(String name) {
        this.name = name;
        this.location = START_POSITION;
    }

    public void printLocation(Car car) {
        int location = car.getLocation();
        String name = car.getName();

        System.out.println(name + " : " + "-".repeat(location));
    }

    public void canForward(int randomNumber) {
        if (randomNumber >= MIN_NUMBER_TO_MOVE) {
            this.location += MOVE_DISTANCE;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }
}
