package racingcar;

import java.util.List;
import racingcar.dto.MoveOpportunityCreateRequest;
import racingcar.dto.RacingCarCreateRequest;
import racingcar.dto.RacingCarResponse;

public interface RacingGameView {
    MoveOpportunityCreateRequest inputMoveOpportunityCreateRequest();

    RacingCarCreateRequest inputRacingCarCreateRequest();

    void printResultTitle();

    void printResult(List<RacingCarResponse> racingCarResponses);

    void printWinners(List<RacingCarResponse> racingCarResponses);
}
