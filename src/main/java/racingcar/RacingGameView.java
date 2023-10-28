package racingcar;

import java.util.List;
import racingcar.dto.MoveOpportunityCreateRequest;
import racingcar.dto.RacingCarCreateRequest;
import racingcar.dto.RacingCarDto;

public interface RacingGameView {
    MoveOpportunityCreateRequest inputMoveOpportunityCreateRequest();

    RacingCarCreateRequest inputRacingCarCreateRequest();

    void printResultTitle();

    void printResult(List<RacingCarDto> racingResultDtos);

    void printWinners(List<RacingCarDto> racingCarDtos);
}
