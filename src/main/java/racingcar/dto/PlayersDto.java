package racingcar.dto;

import java.util.Collections;
import java.util.List;
import racingcar.domain.Player;

public class PlayersDto {
    private final List<Player> players;

    public PlayersDto(final List<Player> players) {
        this.players = players;
    }

    public static PlayersDto from(final List<Player> players) {
        return new PlayersDto(players);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<String> getWinnerList() {
        return players.stream()
                .filter(Player::isWinner)
                .map(player -> player.getPlayerName().getValue())
                .toList();
    }
}
