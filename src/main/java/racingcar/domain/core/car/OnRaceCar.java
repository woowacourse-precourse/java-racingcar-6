package racingcar.domain.core.car;

public class OnRaceCar implements CarDomain, MovingCar {

    private final Car savedCar;
    private final Long position;


    public OnRaceCar(Car car, Long position) {
        this.savedCar = car;
        this.position = position;
    }

    @Override
    public CarName getCarName() {
        return savedCar.getCarName();
    }

    public Long getPosition() {
        return position;
    }

    @Override
    public OnRaceCar move(MoveSignal signal) {
        Long movedPosition = signal.move(position);
        return new OnRaceCar(savedCar, movedPosition);
    }
}
