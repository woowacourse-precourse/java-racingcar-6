package racingcar.model.dto;

import java.util.List;

public class CarResponseDto {
    private final List<String> carNames;

    public CarResponseDto(List<String> carNames) {
        this.carNames = carNames;
    }

    public String createMessage() {
        return String.join(",", carNames);
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
