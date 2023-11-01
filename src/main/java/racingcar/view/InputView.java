package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.InputValidator;

import java.util.List;

public class InputView {
    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public List<String> getCarsName() {
        return inputValidator.convertNames(Console.readLine());
    }

    public int getPlayCount() {
        return inputValidator.convertCount(Console.readLine());
    }

}
