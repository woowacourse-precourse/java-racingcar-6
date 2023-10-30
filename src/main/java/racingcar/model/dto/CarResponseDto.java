package racingcar.model.dto;

import static racingcar.model.constants.Rule.DELIMITER;

import java.util.List;

public class CarResponseDto {
    private final List<String> carNames;

    public CarResponseDto(List<String> inputCharNames) {
        carNames = inputCharNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
    
    public String getWinnerCarNames() {
        return String.join(DELIMITER.getMessage(), carNames);
    }
}
