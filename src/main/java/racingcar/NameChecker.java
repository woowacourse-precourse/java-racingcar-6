package racingcar;

public class NameChecker {
    private static final String EMPTY_INPUT_MESSAGE = "빈 문자열은 이름으로 입력할 수 없습니다.";
    private static final String NULL_INPUT_MESSAGE = "NULL은 이름으로 입력할 수 없습니다.";
    private static final String NAME_LENGTH_LIMIT_MESSAGE = "각 이름은 5자를 초과할 수 없습니다.";

    private static final int MAX_NAME_LENGTH = 5;

    public static void checkName(String name){
        checkNull(name);
        checkEmpty(name);
        checkLengthLimit(name);
    }

    private static void checkNull(String input){
        if(input == null){
            throw new IllegalArgumentException(NULL_INPUT_MESSAGE);
        }
    }

    private static void checkEmpty(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    private static void checkLengthLimit(String input){
        if(input.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_MESSAGE);
        }
    }
}
