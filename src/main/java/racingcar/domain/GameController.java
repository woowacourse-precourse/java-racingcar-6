package racingcar.domain;

import java.util.List;
import racingcar.dto.MoveResultDto;
import racingcar.dto.PlayerNamesDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final MoveFactory moveFactory;

    public GameController(final MoveFactory moveFactory) {
        this.moveFactory = moveFactory;
    }

    public void start() {
        Players players = createPlayers();
        RaceRound raceRound = initializeRaceRound(players);
        RaceCount raceCount = InputView.InputRaceCount();

        playRace(raceRound, raceCount);
        printWinners(raceRound, players);
    }

    private void printWinners(final RaceRound raceRound, final Players players) {
        raceRound.checkWinner();
        OutputView.printWinners(players.getWinnerList());
    }

    private void playRace(final RaceRound raceRound, final RaceCount raceCount) {
        RacingGame racingGame = RacingGame.init(raceRound);
        OutputView.printPreResultMessage();
        do {
            racingGame.move();
            printMoveResult(raceRound);
        } while (!racingGame.isSameCount(raceCount));
    }

    private void printMoveResult(final RaceRound raceRound) {
        List<MoveResultDto> moveResultDtoList = raceRound.getPlayerMoveList().stream()
                .map(MoveResultDto::from)
                .toList();
        OutputView.printMoveResult(moveResultDtoList);
    }

    private RaceRound initializeRaceRound(final Players players) {
        List<PlayerMove> playerMoveList = players.getPlayers().stream()
                .map(PlayerMove::init)
                .toList();
        return RaceRound.of(playerMoveList, moveFactory);
    }

    private Players createPlayers() {
        PlayerNamesDto playerNamesDto = InputView.InputPlayerNames();
        List<Player> players = playerNamesDto.getPlayerNames().stream()
                .map(Player::from)
                .toList();
        return Players.from(players);
    }
}
