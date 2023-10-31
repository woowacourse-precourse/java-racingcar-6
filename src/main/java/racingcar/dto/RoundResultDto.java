package racingcar.dto;

import java.util.List;

public class RoundResultDto {

    private final List<CarStatusDto> roundResult;

    public RoundResultDto(List<CarStatusDto> roundResult) {
        this.roundResult = roundResult;
    }

    public List<CarStatusDto> getRoundResult() {
        return roundResult;
    }
}
