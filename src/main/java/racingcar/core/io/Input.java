package racingcar.core.io;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Input {
    private final Validator validator;
    private final NamesParser parser;

    public Input(final Validator validator, final NamesParser parser) {
        this.validator = validator;
        this.parser = parser;
    }

    private final static String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_MAX_TRY = "시도할 회수는 몇회인가요?";
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
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void useValidator(final List<String> parsedNames) {
        validator.valid(parsedNames);
    }


    public List<String> useParser(String userInput) {
        return parser.parsing(userInput);
    }
}
