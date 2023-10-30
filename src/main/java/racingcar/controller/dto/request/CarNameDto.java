package racingcar.controller.dto.request;

import java.util.List;

public class CarNameDto {
    private final List<String> carNameList;

    public CarNameDto(List<String> carNameList) {
        this.carNameList = carNameList;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
