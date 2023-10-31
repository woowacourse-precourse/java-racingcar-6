package racingcar;

import java.util.Comparator;

public class RacingCar {
    private final String name;
    public static Comparator<RacingCar>
            positionComparator = Comparator.comparingInt(r -> r.position.getX());
    private Position position = Position.of(0);

    public RacingCar(String name) {
        checkName(name);
        this.name = name;
    }

    public void tryForward(int randomDice) {
        if (randomDice >= 4) {
            position = position.forward(1);
        }
    }

    private static void checkName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("각 자동차의 이름은 1글자 이상 5글자 이하의 글자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s : ", name));
        for (int i = 0; i < position.getX(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public boolean isSamePositionWith(RacingCar other) {
        return this.position.equals(other.position);
    }

    public String getName() {
        return name;
    }
}
