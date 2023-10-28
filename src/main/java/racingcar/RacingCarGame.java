package racingcar;

import static racingcar.RacingCarMapper.toDtoList;

import java.util.List;
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
        List<String> racingCarNames = racingCarCreateRequest.getRacingCarNames();

        MoveOpportunityCreateRequest moveOpportunityCreateRequest = view.inputMoveOpportunityCreateRequest();
        MoveOpportunity moveOpportunity = new MoveOpportunity(moveOpportunityCreateRequest.getMoveOpportunity());

        RacingCarRegistry racingCarRegistry
                = new RacingCarRegistry(actionNumberGenerator, racingCarNames, moveOpportunity);

        view.printResultTitle();

        do {
            view.printResult(toDtoList(racingCarRegistry.move()));
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(toDtoList(racingCarRegistry.calculateWinner()));
    }
}
