package racingcar.car;

public class CarMover implements Runnable{
    private final Car car;

    CarMover(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.move();
    }
}
