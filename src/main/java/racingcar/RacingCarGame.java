package racingcar;

import racingcar.dto.MoveCountDto;
import racingcar.dto.RacingCarNameRegistryDto;

public class RacingCarGame {

    private final RacingGameConsoleView view;

    public RacingCarGame(RacingGameConsoleView view) {
        this.view = view;
    }

    public void play() {
        RacingCarNameRegistryDto racingCarNameRegistryDto = view.inputRacingCarNames();
        MoveCountDto moveCountDto = view.inputMoveCount();

        RacingCarRegistry racingCarRegistry = RacingCarRegistryMapper.toRacingCarRegistry(
                new RandomActionNumberGenerator(),
                racingCarNameRegistryDto,
                moveCountDto);

        view.printResultTitle();

        do {
            view.printResult(racingCarRegistry.move());
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(RacingCarMapper.toDtoList(racingCarRegistry.calculateWinner()));
    }
}
