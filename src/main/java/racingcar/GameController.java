package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final MoveFactory moveFactory;

    public GameController(final MoveFactory moveFactory) {
        this.moveFactory = moveFactory;
    }

    public void start() {
        PlayerNamesDto playerNamesDto = InputView.InputPlayerNames();
        PlayersDto playersDto = generatePlayers(playerNamesDto);
        PlayerMoveList playerMoveList = generatePlayerMoveList(playersDto);
    }

    private PlayerMoveList generatePlayerMoveList(PlayersDto playersDto) {
        List<PlayerMove> playerMoveList = playersDto.getPlayers().stream()
                .map(PlayerMove::init)
                .collect(Collectors.toList());

        return PlayerMoveList.of(playerMoveList, moveFactory);
    }

    private PlayersDto generatePlayers(PlayerNamesDto playerNamesDto) {
        List<Player> players = playerNamesDto.getPlayerNames().stream()
                .map(Player::from)
                .collect(Collectors.toList());
        return PlayersDto.from(players);
    }

}
