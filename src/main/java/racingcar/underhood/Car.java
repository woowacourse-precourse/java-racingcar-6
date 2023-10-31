package racingcar.underhood;

import racingcar.RandomNumberGenerator;

public class Car extends RacingGameComponent {

    private CarName name;
    private int distance;
    private GameRule rule;

    public Car(GameRule rule, CarName name) {
        super(rule);
        this.name = name;
        this.distance = 0;
        this.rule = rule;
    }

    public String getName() {
        return this.name.toString();
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        int randomNumber = RandomNumberGenerator.pickRandomNumber(rule);
        if (randomNumber >= 4)
            this.distance += 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Car.class) {
            return false;
        }
        Car that = (Car) obj;
        return (this.name.equals(that.name) && this.distance == that.distance);
    }
}
