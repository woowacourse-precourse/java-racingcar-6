package racingcar.domain;

import java.util.List;
import racingcar.dto.PlayerMoveResultDto;
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
        PlayerMoveList playerMoveList = initializePlayerMoveList(playersDto);
        RaceCount raceCount = InputView.InputRaceCount();

        playRace(playerMoveList, raceCount);
        printWinners(playerMoveList, playersDto);
    }

    private void printWinners(final PlayerMoveList playerMoveList, final PlayersDto playersDto) {
        playerMoveList.checkWinner();
        OutputView.printWinners(playersDto.getWinnerList());
    }

    private void playRace(final PlayerMoveList playerMoveList, final RaceCount raceCount) {
        RacingGame racingGame = RacingGame.init(playerMoveList);
        OutputView.printMoveResultMessage();
        do {
            racingGame.move();
            printMoveResult(playerMoveList);
        } while (!racingGame.isSameCount(raceCount));
    }

    private void printMoveResult(final PlayerMoveList playerMoveList) {
        List<PlayerMoveResultDto> playerMoveResultDtoList = playerMoveList.getPlayerMoveList().stream()
                .map(PlayerMoveResultDto::from)
                .toList();
        OutputView.printPlayerMoveResult(playerMoveResultDtoList);
    }

    private PlayerMoveList initializePlayerMoveList(final PlayersDto playersDto) {
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
