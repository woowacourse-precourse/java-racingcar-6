package racingcar.global.utils.generator;

import racingcar.global.constant.OutputType;
import racingcar.global.utils.ConsoleUtil;

import java.util.Collections;
import java.util.List;

public class InputNumberOfGames implements NumberOfGamesGenerator {

    @Override
    public Integer getNumberOfGames() {
        String input = ConsoleUtil.input();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
        }
    }
}
