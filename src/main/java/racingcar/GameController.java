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
        RaceCount raceCount = InputView.InputRaceCount();

        play(playerMoveList, raceCount);
        getWinner(playerMoveList, playersDto);
    }

    private void getWinner(PlayerMoveList playerMoveList, PlayersDto playersDto) {
        int maxDistacne = playerMoveList.getMaxDistance();
        playerMoveList.checkWinner(maxDistacne);
        List<String> winnerList = playersDto.getWinnerList();
        OutputView.printWinner(winnerList);
    }

    private void play(PlayerMoveList playerMoveList, RaceCount raceCount) {
        OutputView.printMoveResultMessage();
        RacingGame racingGame = RacingGame.init(playerMoveList);
        int tryCount = 0;
        // 여기 리팩토링 필요 @
        do {
            racingGame.move();
            tryCount++;
            List<MoveResultDto> moveResultDtoList = getMoveResultList(playerMoveList);
            OutputView.printMoveResult(moveResultDtoList);
        } while (!raceCount.isSameCount(tryCount));
    }

    private List<MoveResultDto> getMoveResultList(PlayerMoveList playerMoveList) {
        return playerMoveList.getPlayerMoveList().stream()
                .map(MoveResultDto::from)
                .collect(Collectors.toList());
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
