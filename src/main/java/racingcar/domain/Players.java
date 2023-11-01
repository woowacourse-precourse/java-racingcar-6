package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<Player> players) {
        return new Players(players);
    }

    public List<String> getWinnerList() {
        return players.stream()
                .filter(Player::isWinner)
                .map(player -> player.getPlayerName().getValue())
                .toList();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
