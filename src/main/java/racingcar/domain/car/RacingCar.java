package racingcar.domain.car;

import racingcar.domain.forwardMethod.ForwardMethod;

public record RacingCar(Name name, Position position) implements Comparable<RacingCar> {

    private static final int INITIAL_POSITION = 0;

    public RacingCar(String name) {
        this(new Name(name), new Position(INITIAL_POSITION));
    }

    public RacingCar(RacingCar racingCar) {
        this(racingCar.name, racingCar.position);
    }

    public RacingCar move(ForwardMethod forwardMethod) {

        if (forwardMethod.isMovable()) {
            return new RacingCar(name, new Position(position.currentPosition() + 1));
        }
        return this;
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position.currentPosition();
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        return Integer.compare(getPosition(), racingCar.getPosition());
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
