package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Validator;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public void displayCarNamePrompt() {
        System.out.println(Message.CAR_NAME_INPUT.getMessage());
    }

    public void displayRaceCountPrompt() {
        System.out.println(Message.RACE_COUNT.getMessage());
    }

    public List<String> getCarNames() {
        String carNames = Console.readLine();
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();

        Validator.InputCarName(carNameList);
        return carNameList;
    }

    public int getRaceCount() {
        int raceCount = Integer.parseInt(Console.readLine());
        Validator.InputRaceCount(Integer.toString(raceCount));
        return raceCount;
    }

    private enum Message {
        CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RACE_COUNT("시도할 회수는 몇회인가요?");

        private String message;

        Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
