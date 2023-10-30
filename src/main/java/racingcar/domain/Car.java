package racingcar.domain;


import racingcar.strategy.RacingCarMoveStrategy;

public class Car {
    private final CarName name;
    private final Lap lap;

    public Car(String name) {
        this.name = new CarName(name);
        this.lap = new Lap(0);
    }

    private Car(CarName name, Lap lap) {
        this.name = name;
        this.lap = lap;
    }

    public Car move(RacingCarMoveStrategy racingCarMoveStrategy) {
        if (racingCarMoveStrategy.isMovable()) {
            return new Car(name, lap.nextLap());
        }
        return this;
    }

    public String getName() {
        return name.value();
    }

    public int getLap() {
        return lap.count();
    }

}
