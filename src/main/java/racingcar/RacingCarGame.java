package racingcar;

import static racingcar.RacingCarMapper.toDtoList;

import racingcar.dto.MoveOpportunityCreateRequest;
import racingcar.dto.RacingCarCreateRequest;

public class RacingCarGame {

    private final RacingGameConsoleView view;

    public RacingCarGame(RacingGameConsoleView view) {
        this.view = view;
    }

    public void play() {
        RacingCarCreateRequest racingCarCreateRequest = view.inputRacingCarCreateRequest();
        MoveOpportunityCreateRequest moveOpportunityCreateRequest = view.inputMoveOpportunityCreateRequest();

        RacingCarRegistry racingCarRegistry = RacingCarRegistryMapper.toRacingCarRegistry(
                new RandomActionNumberGenerator(),
                racingCarCreateRequest,
                moveOpportunityCreateRequest);

        view.printResultTitle();

        do {
            view.printResult(toDtoList(racingCarRegistry.move()));
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(toDtoList(racingCarRegistry.calculateWinner()));
    }
}
