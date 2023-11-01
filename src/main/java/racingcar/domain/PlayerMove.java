package racingcar.domain;

import static racingcar.domain.Constant.DEFAULT_DISTANCE;

import java.util.Objects;

public class PlayerMove {

    private final Player player;
    private final Distance distance;

    private PlayerMove(final Player player, final Distance distance) {
        this.player = player;
        this.distance = distance;
    }

    public static PlayerMove init(final Player player) {
        return new PlayerMove(player, Distance.from(DEFAULT_DISTANCE));
    }

    public static PlayerMove of(final Player player, Distance distance) {
        return new PlayerMove(player, distance);
    }

    public static PlayerMove from(final Player player, final Distance distance) {
        return new PlayerMove(player, distance);
    }

    public void move(final boolean isMove) {
        if (isMove) {
            distance.increase();
        }
    }

    public int getMaxDistance(final int presentMax) {
        return distance.getMax(presentMax);
    }

    public void checkWinner(final int presentMax) {
        if (distance.isMax(presentMax)) {
            player.checkWinner();
        }
    }

    public Distance getDistance() {
        return distance;
    }

    public String getPlayerRawName() {
        return player.getRawPlayerName();
    }

    public int getRawDistance() {
        return distance.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerMove that = (PlayerMove) o;
        return Objects.equals(player, that.player) && Objects.equals(distance,
                that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, distance);
    }
}
