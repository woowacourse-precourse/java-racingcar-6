package racingcar.domain.core.car;

public class OnRaceCar implements BasicCar, MovingCar {

    private final BasicCar savedCar;
    private final Long position;


    public OnRaceCar(BasicCar car, Long position) {
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
