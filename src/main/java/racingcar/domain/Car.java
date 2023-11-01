package racingcar.domain;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final ForwardDistance forwardDistance;

    public Car(final CarName name) {
        this.name = name;
        this.forwardDistance = new ForwardDistance();
    }

    public void runRound(NumberGenerator numberGenerator, ForwardChecker forwardChecker) {
        int number = numberGenerator.createNumber();
        if (forwardChecker.checkIfForward(number)) {
            forward();
        }
    }

    private void forward() {
        forwardDistance.increase();
    }

    public String getName() {
        return name.getValue();
    }

    public int getForwardDistance() {
        return forwardDistance.getValue();
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.forwardDistance.getValue(), other.forwardDistance.getValue());
    }

    @Override
    public String toString() {
        return name + " : " + forwardDistance.toString();
    }
}
