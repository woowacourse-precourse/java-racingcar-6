package racingcar.dto;

import racingcar.domain.CarGroup;

public record ResultResponseDto(
    CarGroup carGroup,
    int roundNumber
) {

}