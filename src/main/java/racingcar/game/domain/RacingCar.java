package racingcar.game.domain;

import java.util.Comparator;
import racingcar.game.renderer.RacingCarGameRenderer;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_VALUE = 4;
    private static final int FORWARD_STEP = 1;
    public static Comparator<RacingCar>
            positionComparator = Comparator.comparingInt(r -> r.position.getX());
    private final String name;
    private Position position = Position.of(0);

    public RacingCar(String name) {
        checkName(name);
        this.name = name;
    }

    private static void checkName(String name) {
        if (name.length() == 0 || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("각 자동차의 이름은 1글자 이상 5글자 이하의 글자여야 합니다.");
        }
    }

    public void tryForward(int number) {
        if (number >= FORWARD_VALUE) {
            position = position.forward(FORWARD_STEP);
        }
    }

    public boolean isSamePositionWith(RacingCar other) {
        return this.position.equals(other.position);
    }

    public String getName() {
        return name;
    }

    public String render(RacingCarGameRenderer renderer) {
        return renderer.renderCar(name, position);
    }
}
