package racingcar;

import racingcar.dto.CreateRacingCarRequest;
import racingcar.dto.MoveCountDto;

public class RacingCarGame {

    private final RacingGameConsoleView view;

    public RacingCarGame(RacingGameConsoleView view) {
        this.view = view;
    }

    public void play() {
        CreateRacingCarRequest createRacingCarRequest = view.inputRacingCarNames();
        MoveCountDto moveCountDto = view.inputMoveCount();

        RacingCarRegistry racingCarRegistry = RacingCarRegistryMapper.toRacingCarRegistry(
                new RandomActionNumberGenerator(),
                createRacingCarRequest,
                moveCountDto);

        view.printResultTitle();

        do {
            view.printResult(racingCarRegistry.move());
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(RacingCarMapper.toDtoList(racingCarRegistry.calculateWinner()));
    }
}
