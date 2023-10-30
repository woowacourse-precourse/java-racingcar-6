package racingcar.core.io;

import racingcar.core.utils.NamesParser;
import racingcar.core.utils.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.InputConstant.INPUT_CARS_NAME;
import static racingcar.constant.InputConstant.INPUT_MAX_TRY;

public class Input {
    private final Validator validator;
    private final NamesParser parser;

    public Input(final Validator validator, final NamesParser parser) {
        this.validator = validator;
        this.parser = parser;
    }
    public List<String> readNames(){
        System.out.println(INPUT_CARS_NAME);
        String userInput = readLine();

        List<String> parsedNames = useParser(userInput);
        useValidator(parsedNames);

        return parsedNames;
    }
    public int readTryNum(){
        System.out.println(INPUT_MAX_TRY);
        try {
            return parseInt();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    private static int parseInt() {
        int res = Integer.parseInt(readLine());
        if (res < 1) {
            throw new IllegalArgumentException();
        }
        return res;
    }
    private void useValidator(final List<String> parsedNames) {
        validator.valid(parsedNames);
    }
    public List<String> useParser(String userInput) {
        return parser.parsing(userInput);
    }
}
