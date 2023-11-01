package racingcar.dto;

import java.util.List;

public record UserCarNameDto(List<String> carNames) {

    public UserCarNameDto(List<String> carNames) {
        this.carNames = carNames;
    }
}
