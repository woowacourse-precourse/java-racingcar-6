package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private enum InputMessage {
        REQUEST_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        REQUEST_INPUT_ROUND_NUMBER("시도할 회수는 몇회인가요?"),
        EXCEED_NAME_SIZE_LIMIT("자동차 이름은 5글자 이하여야 합니다."),
        NONE_ARABIC_NUMBER("아라비아 숫자만 입력 가능합니다."),
        EMPTY_INPUT("빈 값은 입력할 수 없습니다.");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }

    private static final String SEPARATOR = ",";
    private static final int NAME_SIZE_LIMIT = 5;
    private static final Pattern ARABIC_NUMBER_PATTERN = Pattern.compile("^[0-9]?$");

    public List<String> inputName() {
        System.out.println(InputMessage.REQUEST_INPUT_CAR_NAME.message);
        String input = Console.readLine();
        validateEmptyInput(input);
        List<String> names = Arrays.asList(input.split(SEPARATOR));
        validateFiveCharacter(names);

        return names.stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputNumber() {
        System.out.println(InputMessage.REQUEST_INPUT_ROUND_NUMBER.message);
        String number = Console.readLine();
        validateArabicNumber(number);
        validateEmptyInput(number);

        return Integer.parseInt(number);
    }

    public void validateFiveCharacter(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > NAME_SIZE_LIMIT)) {
            throw new IllegalArgumentException(InputMessage.EXCEED_NAME_SIZE_LIMIT.message);
        }
    }

    public void validateArabicNumber(String input) {
        if (!ARABIC_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(InputMessage.NONE_ARABIC_NUMBER.message);
        }
    }

    public void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputMessage.EMPTY_INPUT.message);
        }
    }
}
