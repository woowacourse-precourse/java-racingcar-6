package racingcar.dto;

public class UserRequestDTO {

    private final String carNames;

    private final String tryNum;

    public UserRequestDTO(String carNames, String tryNum) {
        this.carNames = carNames;
        this.tryNum = tryNum;
    }

    public String getCarNames() {
        return carNames;
    }

    public String getTryNum() {
        return tryNum;
    }

}
