package racingcar;

public class Car {
    Name carName;
    Status carStatus;
    Location carLocation;

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVING_NUMBER = 4;
    static RandomNumber carRandomNumber = RandomNumber.fromInteger(RANDOM_START, RANDOM_END);

    private Car(String carName) {
        this.carName = Name.createName(carName);
        this.carLocation = Location.fromInteger(0);
        this.carStatus = Status.STOP;
    }

    static Car fromString(String carName) {
        return new Car(carName);
    }

    public Name getCarName() {
        return carName;
    }

    public Status getCarStatus() {
        return carStatus;
    }

    public Location getCarLocation() {
        return carLocation;
    }

    public void setCarStatus(Status carStatus) {
        this.carStatus = carStatus;
    }

    public void move() {
        if (this.carStatus == Status.MOVING_FORWARD) {
            this.carLocation.step();
            this.setCarStatus(Status.STOP);
        }
    }

    public void moveCarOnRandomCondition() {
        int randomResult = carRandomNumber.pickNumber();
        if (randomResult >= MOVING_NUMBER) {
            this.setCarStatus(Status.MOVING_FORWARD);
            this.move();
        }
    }

    public boolean isSameLocation(Location compareLocation){
        return this.carLocation.equals(compareLocation);
    }

    public void displayCarLocation() {
        OutputView.printFormatStatus(carName.getName(), carLocation.getStringPosition());
    }
}
