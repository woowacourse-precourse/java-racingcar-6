package racingcar.system.converter;

import racingcar.model.Round;

public class StringToRound {
    public static Round convertStringToRound(String input) {
        return new Round(Integer.parseInt(input));
    }
}
