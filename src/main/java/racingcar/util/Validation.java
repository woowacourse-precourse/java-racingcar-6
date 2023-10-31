package racingcar.util;

import java.util.List;

public class Validation {

    private static final String CORRECT_CHECK_MESSAGE = "영문자와 쉼표(,)만 입력 가능합니다. (공백 사용 불가)";
    private static final String LENGTH_EXCEED_MESSAGE = "자동차의 이름이 5글자까지 가능합니다.";
    private static final String STRING_LAST_REST_MESSAGE = "쉼표(,)로 끝나는건 불가능합니다. 이름을 작성해주세요";
    private static final String NO_NAME_MESSAGE = "자동차의 이름음 1자 이상이여야 합니다.";
    private static final String IMPOSSIBLE_RACING_MESSAGE = "최소 2명 이상의 참가자가 있어야 게임을 할 수 있습니다.";
    private static final String NO_ZERO_ATTEMPT_MESSAGE = "최소 1번 이상의 레이싱은 해야합니다.";
    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 0;
    private static final int MIN_RACING_CAR = 2;
    private static final char REST = ',';
    private static final int MIN_RACING_ATTEMPT = 0;

    public static void stringImpossibleRest(String input) {

        if (input.charAt(input.length() - 1) == REST) {
            throw new IllegalArgumentException(STRING_LAST_REST_MESSAGE);
        }

    }

    public static void stringCurrentCheck(List<String> input) {
        for (String name : input) {
            if (!name.matches("^[a-zA-Z]*$")) {
                throw new IllegalArgumentException(CORRECT_CHECK_MESSAGE);
            }
        }
    }
    public static void stringLengthExceed(List<String> input) {

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(LENGTH_EXCEED_MESSAGE);
            }
        }

    }

    public static void stringNoName(List<String> input) {

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).length() == NAME_MIN_LENGTH) {
                throw new IllegalArgumentException(NO_NAME_MESSAGE);
            }
        }

    }

    public static void impossibleRacing(List<String> input) {
        if (input.size() < MIN_RACING_CAR) {
            throw new IllegalArgumentException(IMPOSSIBLE_RACING_MESSAGE);
        }
    }

    public static void noZeroNumber(String input) {
        if (input.equals(MIN_RACING_ATTEMPT)) {
            throw new IllegalArgumentException(NO_ZERO_ATTEMPT_MESSAGE);
        }
    }

    public static void onlyPossibleNumber(String input) {
        if (!input.matches("^*[0-9]*$")) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }



}
