package racingcar;

import java.util.List;
import racingcar.dto.MoveOpportunityCreateRequest;
import racingcar.dto.RacingCarCreateRequest;

public class RacingCarRegistryMapper {

    public static RacingCarRegistry toRacingCarRegistry(
            ActionNumberGenerator actionNumberGenerator,
            RacingCarCreateRequest racingCarCreateRequest,
            MoveOpportunityCreateRequest moveOpportunityCreateRequest) {
        MoveOpportunity moveOpportunity = new MoveOpportunity(moveOpportunityCreateRequest.getMoveOpportunity());
        List<String> racingCarNames = racingCarCreateRequest.getRacingCarNames();
        return new RacingCarRegistry(actionNumberGenerator, racingCarNames, moveOpportunity);
    }
}
