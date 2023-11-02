package racingcar.domain;

public final class Car {
    private final String name;
    private final MoveRule moveRule;
    private int distance;

    private Car(String name, MoveRule moveRule) {
        this.name = name;
        this.moveRule = moveRule;
        distance = 0;
    }

    public void move() {
        distance += moveRule.tryMove();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static class CarBuilder {
        private final String name;
        private MoveRule moveRule = new ThresholdScoreMoveRule(new RandomNumberGenerator());

        public CarBuilder(String name) {
            this.name = name;
        }

        public CarBuilder setMoveRule(MoveRule moveRule) {
            this.moveRule = moveRule;
            return this;
        }

        public Car build() {
            return new Car(name, moveRule);
        }
    }
}
