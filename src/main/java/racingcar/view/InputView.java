package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.TypeConvertor;

import java.util.List;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<String> getInputCarNames() {
        System.out.println(Message.INPUT_CARS.message);
        String input = Console.readLine();
        return TypeConvertor.stringToStringList(input);
    }

    public Integer getTryCount() {
        System.out.println(Message.INPUT_MOVE_COUNT.message);
        String input = Console.readLine();
        return TypeConvertor.stringToInt(input);
    }

    private enum Message {
        INPUT_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(message, replaces);
        }
    }
}
