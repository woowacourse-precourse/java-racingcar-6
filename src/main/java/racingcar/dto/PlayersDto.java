package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Player;

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

    public List<String> getWinnerList() {
        return players.stream()
                .filter(Player::isWinner)
                .map(player -> player.getPlayerName().getValue())
                .collect(Collectors.toList());
    }
            /*
        playersDto에 list <player>이 있다
        그걸 돌면서 isWinner가 true인 애의 playerName 또는 Player 자체를 리턴하면 되는데.

        * */
}
