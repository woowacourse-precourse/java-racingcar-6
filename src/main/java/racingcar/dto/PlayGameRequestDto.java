package racingcar.dto;

import java.util.List;

public class PlayGameRequestDto {
    public List<String> carNameList;
    public Integer tryNumber;

    public PlayGameRequestDto(List<String> carNameList, Integer tryNumber) {
        this.carNameList = carNameList;
        this.tryNumber = tryNumber;
    }

    public List<String> getCarNameString() {
        return carNameList;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }
}
