package racingcar.model.dto;

import racingcar.model.Cars;

public class InputDTO {
    private final String input;

    public InputDTO(String input) {
        this.input = input;
    }

    public Cars toCars() {
        return new Cars(input);
    }
}
