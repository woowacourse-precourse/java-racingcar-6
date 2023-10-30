package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.CarListEditor;
import racingcar.util.CarNameValidator;
import racingcar.util.MoveCountValidator;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public List<String> readCarNames() {
        System.out.println(Message.INPUT_START.message);
        String input = CarListEditor.removeSpace(Console.readLine());
        List<String> names = CarListEditor.splitByComma(input);
        CarNameValidator.validate(names);
        return names;
    }

    public int readMoveCount() {
        System.out.println(Message.INPUT_MOVE_COUNT.message);
        String input = CarListEditor.removeSpace(Console.readLine());
        MoveCountValidator.validate(input);
        return Integer.parseInt(input);
    }

    public enum Message {
        INPUT_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
