package racingcar;

import java.util.List;
import racingcar.dto.CreateMoveOpportunityRequest;
import racingcar.dto.CreateRacingCarRequest;

public class RacingCarRegistryMapper {

    public static RacingCarRegistry toRacingCarRegistry(
            ActionNumberGenerator actionNumberGenerator,
            CreateRacingCarRequest createRacingCarRequest,
            CreateMoveOpportunityRequest createMoveOpportunityRequest) {
        MoveOpportunity moveOpportunity = new MoveOpportunity(createMoveOpportunityRequest.getMoveOpportunity());
        List<String> racingCarNames = createRacingCarRequest.getRacingCarNames();
        return new RacingCarRegistry(actionNumberGenerator, racingCarNames, moveOpportunity);
    }
}
