package racingcar.dto;

import static racingcar.constant.Message.COLON_WITH_WHITESPACE;

public class RacingStatusDTO {

    private String carName;

    private String location;

    public RacingStatusDTO(String carName, String location) {
        this.carName = carName;
        this.location = location;
    }

    @Override
    public String toString() {
        return carName + COLON_WITH_WHITESPACE.getMessage() + location + "\n";
    }

}
