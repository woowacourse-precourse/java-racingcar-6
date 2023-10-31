package racingcar.dto;

import java.util.List;

public class RoundResultDto {
    private List<CarStateDto> carStates;

    public RoundResultDto(List<CarStateDto> carStates) {
        this.carStates = carStates;
    }

    public List<CarStateDto> getCarStates() {
        return carStates;
    }
}