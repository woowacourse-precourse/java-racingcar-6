package racingcar;

import java.util.List;

public class PlayersDto {
    private final List<Player> players;

    public PlayersDto(final List<Player> players) {
        this.players = players;
    }

    public static PlayersDto from(List<Player> players) {
        return new PlayersDto(players);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
