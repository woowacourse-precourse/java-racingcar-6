package racingcar;

import static racingcar.RacingCarMapper.toDtoList;

import racingcar.dto.MoveOpportunityCreateRequest;
import racingcar.dto.RacingCarCreateRequest;

public class RacingCarGame {

    private final RacingGameView view;
    private final ActionNumberGenerator actionNumberGenerator;

    public RacingCarGame(RacingGameView view, ActionNumberGenerator actionNumberGenerator) {
        this.view = view;
        this.actionNumberGenerator = actionNumberGenerator;
    }

    public void play() {
        RacingCarCreateRequest racingCarCreateRequest = view.inputRacingCarCreateRequest();
        MoveOpportunityCreateRequest moveOpportunityCreateRequest = view.inputMoveOpportunityCreateRequest();

        RacingCarRegistry racingCarRegistry = RacingCarRegistryMapper.toRacingCarRegistry(
                actionNumberGenerator,
                racingCarCreateRequest,
                moveOpportunityCreateRequest);

        view.printResultTitle();

        do {
            view.printResult(toDtoList(racingCarRegistry.move()));
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(toDtoList(racingCarRegistry.calculateWinner()));
    }
}
