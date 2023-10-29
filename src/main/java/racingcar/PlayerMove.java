package racingcar;

import java.util.Objects;

public class PlayerMove {

    private final Player player;
    private final Distance distance;

    public PlayerMove(Player player, Distance distance) {
        this.player = player;
        this.distance = distance;
    }

    public static PlayerMove init(Player player) {
        return new PlayerMove(player, Distance.from(0));
    }

    public static PlayerMove of(Player player, Distance distance) {
        return new PlayerMove(player, distance);
    }

    public void move(boolean isMove) {
        if (isMove) {
            distance.increase();
        }
    }

    public int getMaxDistance(int presentMax) {
        return distance.getMaxDistance(presentMax);
    }

    public void checkWinner(int max) {
        if (distance.isMax(max)) {
            player.checkWinner();
        }
    }

    public Distance getDistance() {
        return distance;
    }

    public Player getPlayer() {
        return player;
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

    public static PlayerMove fromTest() {
        Player testPlayer = Player.from("test");
        Distance initDistance = Distance.from(0);
        return new PlayerMove(testPlayer, initDistance);
    }
}
