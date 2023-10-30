package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private enum InputMessage {
        REQUEST_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }

    private static final String SEPARATOR = ",";


    public List<String> inputName() {
        System.out.println(InputMessage.REQUEST_INPUT_CAR_NAME.message);
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(SEPARATOR));

        return names.stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }
}
