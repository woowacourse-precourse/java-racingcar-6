package racingcar.global.utils.generator;

import racingcar.global.constant.OutputType;
import racingcar.global.utils.ConsoleUtil;

import java.util.Arrays;
import java.util.List;

public class InputNamesGenerator implements NamesGenerator {

    @Override
    public List<String> nameGenerate() {
        String input = ConsoleUtil.input();
        try {
            return Arrays.stream(input.split(","))
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
        }
    }
}
