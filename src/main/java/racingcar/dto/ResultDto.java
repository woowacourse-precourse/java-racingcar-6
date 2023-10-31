package racingcar.dto;

import racingcar.model.CarGroup;

public record ResultDto (
    CarGroup carGroup,
    int roundNumber
) {

}