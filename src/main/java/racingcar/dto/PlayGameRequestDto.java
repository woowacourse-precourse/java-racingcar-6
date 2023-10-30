package racingcar.dto;

public class PlayGameRequestDto {
    public String carNameString;
    public Integer tryNumber;

    public PlayGameRequestDto(String carNameString, Integer tryNumber) {
        this.carNameString = carNameString;
        this.tryNumber = tryNumber;
    }

    public String getCarNameString() {
        return carNameString;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }
}
