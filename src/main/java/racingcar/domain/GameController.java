package racingcar.domain;

import java.util.List;
import racingcar.dto.MoveResultDto;
import racingcar.dto.PlayerNamesDto;
import racingcar.dto.PlayersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final MoveFactory moveFactory;

    public GameController(final MoveFactory moveFactory) {
        this.moveFactory = moveFactory;
    }

    public void start() {
        PlayersDto playersDto = generatePlayers();
        PlayerMoveList playerMoveList = generatePlayerMoveList(playersDto);
        RaceCount raceCount = InputView.InputRaceCount();

        playRace(playerMoveList, raceCount);
        printWinner(playerMoveList, playersDto);
    }

    private void printWinner(final PlayerMoveList playerMoveList, final PlayersDto playersDto) {
        playerMoveList.checkWinner();
        OutputView.printWinner(playersDto.getWinnerList());
    }

    private void playRace(final PlayerMoveList playerMoveList, final RaceCount raceCount) {
        RacingGame racingGame = RacingGame.init(playerMoveList);
        OutputView.printMoveResultMessage();
        do {
            racingGame.move();
            printMove(playerMoveList);
        } while (!racingGame.isSameCount(raceCount));
    }

    private void printMove(final PlayerMoveList playerMoveList) {
        List<MoveResultDto> moveResultDtoList = playerMoveList.getPlayerMoveList().stream()
                .map(MoveResultDto::from)
                .toList();
        OutputView.printMoveResult(moveResultDtoList);
    }

    private PlayerMoveList generatePlayerMoveList(final PlayersDto playersDto) {
        List<PlayerMove> playerMoveList = playersDto.getPlayers().stream()
                .map(PlayerMove::init)
                .toList();
        return PlayerMoveList.of(playerMoveList, moveFactory);
    }

    private PlayersDto generatePlayers() {
        PlayerNamesDto playerNamesDto = InputView.InputPlayerNames();
        List<Player> players = playerNamesDto.getPlayerNames().stream()
                .map(Player::from)
                .toList();
        return PlayersDto.from(players);
    }
}
