package racingcar;

import java.util.Objects;

public class Player {
    private String name;
    private Integer position;

    private Player(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(String name) {
        validateCarName(name);
        return new Player(name, 0);
    }

    public static Player of(String name, Integer position) {
        validateCarName(name);
        validatePositionRange(position);
        return new Player(name, position);
    }

    private static void validatePositionRange(Integer position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
