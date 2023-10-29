package racingcar.domain.core.car;

public class OnRaceCar {

    private final Car savedCar;
    private final Long position;


    public OnRaceCar(Car car, Long position) {
        this.savedCar = car;
        this.position = position;
    }

    public Car getCar() {
        return savedCar;
    }

    public CarName getCarName() {
        return savedCar.getCarName();
    }

    public String getName() {
        return savedCar.getName();
    }

    public Long getPosition() {
        return position;
    }

    public OnRaceCar move(MoveSignal signal) {
        Long movedPosition = signal.move(position);
        return new OnRaceCar(this.getCar(), movedPosition);
    }
}
