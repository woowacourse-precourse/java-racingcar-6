package racingcar.model.car;

public class Car {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVABLE_THRESHOLD = 4;

    private RandomUtil randomUtil;
    private final String name;
    private Integer position;

    public Car(String name, Integer position, RandomUtil randomUtil) {
        this.name = name;
        this.position = position;
        this.randomUtil = randomUtil;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return MOVABLE_THRESHOLD <= randomUtil.generate(MIN_BOUND, MAX_BOUND);
    }
}
