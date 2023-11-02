package racingcar.domain;

import java.util.Comparator;
import java.util.function.BiFunction;

public class Car {

    private int distance;
    private final String name;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int DISTANCE_MIN = 0;
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int FORWARD_CONDITION = 4;

    static public class Greater implements Comparator<Car> {

        @Override
        public int compare(Car car1, Car car2) {
            return car1.getDistance() - car2.getDistance();
        }
    }


    public Car(String name, int distance) {
        constructorValidation(name, distance);
        this.name = name;
        this.distance = distance;
    }

    private void constructorValidation(String name, int distance) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH || distance < DISTANCE_MIN) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.distance);
    }

    public void forward(BiFunction<Integer, Integer, Integer> randomFunction) {
        int randomNumber = randomFunction.apply(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
        if (randomNumber >= FORWARD_CONDITION) {
            ++this.distance;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
