package racingcar.entity;

import java.util.Objects;

class Car {

    private static final String UNKNOWN_POLICY_MESSAGE = "알 수 없는 이동 정책입니다.";

    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(Name.from(name), Position.newInstance());
    }

    public void move(MovePolicy policy) {
        checkPolicyNonNull(policy);

        if (policy.isMovable()) {
            position.increase();
        }
    }

    private void checkPolicyNonNull(MovePolicy policy) {
        if (Objects.isNull(policy)) {
            throw new IllegalArgumentException(UNKNOWN_POLICY_MESSAGE);
        }
    }

    public CarDescription describeSelf() {
        return new CarDescription(name.getName(), position.getPosition());
    }
}
