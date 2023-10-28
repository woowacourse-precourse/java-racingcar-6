package racingcar.game;

import static racingcar.game.RacingCarMapper.toDtoList;

import java.util.List;
import racingcar.actionnumber.ActionNumberGenerator;
import racingcar.dto.MoveOpportunityCreateRequest;
import racingcar.dto.RacingCarCreateRequest;
import racingcar.model.Name;
import racingcar.view.RacingGameView;

public class RacingCarGame {

    private final RacingGameView view;
    private final ActionNumberGenerator actionNumberGenerator;

    public RacingCarGame(RacingGameView view, ActionNumberGenerator actionNumberGenerator) {
        this.view = view;
        this.actionNumberGenerator = actionNumberGenerator;
    }

    public void play() {
        RacingCarCreateRequest racingCarCreateRequest = view.inputRacingCarCreateRequest();
        List<RacingCar> racingCars = racingCarCreateRequest.getRacingCarNames().stream()
                .map(name -> new RacingCar(Name.of(name)))
                .toList();

        MoveOpportunityCreateRequest moveOpportunityCreateRequest = view.inputMoveOpportunityCreateRequest();
        MoveOpportunity moveOpportunity = new MoveOpportunity(moveOpportunityCreateRequest.getMoveOpportunity());

        RacingCarRegistry racingCarRegistry
                = new RacingCarRegistry(actionNumberGenerator, racingCars, moveOpportunity);

        view.printResultTitle();

        do {
            view.printResult(toDtoList(racingCarRegistry.move()));
        } while (!racingCarRegistry.isRacingOver());

        view.printWinners(toDtoList(racingCarRegistry.calculateWinner()));
    }
}
