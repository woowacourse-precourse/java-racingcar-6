package racingcar.domain.dto.input;

import racingcar.validator.CarNameValidator;

import java.util.List;

public record CarsRequestDto(List<String> carNameList) {

    public CarsRequestDto {
        CarNameValidator.validateWhiteSpace(carNameList);
        CarNameValidator.validateDuplicatedName(carNameList);
        CarNameValidator.validateNameLength(carNameList);
    }
}
