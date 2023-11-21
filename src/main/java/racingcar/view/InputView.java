package racingcar.view;

import java.util.List;
import racingcar.RacingConst;
import racingcar.exception.RacingException;
import racingcar.view.io.Reader;
import racingcar.view.io.Writer;

public class InputView {
    private final Reader reader = new Reader();
    private final Writer writer = new Writer();

    public List<String> getNames() {
        writer.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return reader.readStrings(RacingConst.DELIMITER);
    }

    public int getRoundNumber() {
        writer.printMessage("시도할 회수는 몇회인가요?");
        int input = reader.readInteger();
        validateRoundNumber(input);

        return input;
    }

    private void validateRoundNumber(int input) {
        if (input <= 0) {
            throw RacingException.INVALID_NUMBERS.makeException();
        }
    }

    public void closeConsole() {
        reader.closeConsole();
    }
}
