package racingcar;

import racingcar.dto.CreateMoveOpportunityRequest;
import racingcar.dto.CreateRacingCarRequest;

public class RacingCarGame {

    private final RacingGameConsoleView view;

    public RacingCarGame(RacingGameConsoleView view) {
        this.view = view;
    }

    public void play() {
        CreateRacingCarRequest createRacingCarRequest = view.inputRacingCarNames();
        CreateMoveOpportunityRequest createMoveOpportunityRequest = view.inputMoveOpportunity();

        RacingCarRegistry racingCarRegistry = RacingCarRegistryMapper.toRacingCarRegistry(
                new RandomActionNumberGenerator(),
                createRacingCarRequest,
                createMoveOpportunityRequest);

        view.printResultTitle();

        do {
            view.printResult(racingCarRegistry.move());
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(RacingCarMapper.toDtoList(racingCarRegistry.calculateWinner()));
    }
}
