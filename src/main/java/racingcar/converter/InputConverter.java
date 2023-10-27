package racingcar.converter;

import racingcar.domain.game.Cars;

public class InputConverter {
    public Cars convertStringToCars(String input) {
        return Cars.of(input);
    }

    public int covertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
