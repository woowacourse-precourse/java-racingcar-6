package racingcar.domain.car;

public class Car {

    private final CarName name;
    private final ForwardCount forwardCount;

    private Car(CarName name, ForwardCount forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public static Car nameOf(CarName name) {
        return new Car(name, ForwardCount.defaultOf());
    }

    public void moveForward() {
        this.forwardCount.increaseByOne();
    }

    public long getForwardCount() {
        return this.forwardCount.getCount();
    }

}
