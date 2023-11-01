package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.validation.CommonValidator;
import racingcar.validation.CountValidator;

public class InputView {

    private CountValidator countValidator;
    private CommonValidator commonValidator;

    public InputView() {
        this.countValidator = new CountValidator();
        this.commonValidator = new CommonValidator();
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
        commonValidator.isNull(names);
    }

    private void validateCount(String count) {
        commonValidator.isNull(count);
        countValidator.isContainLetter(count);
        countValidator.isNotNaturalNum(count);
    }
}
