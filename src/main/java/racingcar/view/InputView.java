package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.security.PublicKey;
import java.util.List;
import racingcar.validation.Validator;

public class InputView {

    private Validator inputValidator;

    public InputView() {
        this.inputValidator = new Validator();
    }

    public String readCarName() {
        String names = readLine();
        names = removeBlank(names);
        validateCarName(names);
        return names;
    }

    public int readCount() {
        String count = readLine();
        validateCount(count);
        return Integer.parseInt(count);
    }

    private String removeBlank(String name) {
        return name.replaceAll("\\s", "");
    }

    private void validateCarName(String names) {
        inputValidator.isNull(names);
    }

    private void validateCount(String count) {
        inputValidator.isNull(count);
        inputValidator.isContainLetter(count);
        inputValidator.isNotNaturalNum(count);
    }
}
