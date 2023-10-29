package validator;

import util.NameConstant;
import java.util.regex.Pattern;

public class InputValidator {
    private final String REGEXP_PATTERN_SPACE_NO_CHAR = "^[^\\s]+$";
    private final String REGEXP_PATTERN_ONLY_COMMA = "^,+$";
    private final String REGEXP_PATTERN_ONLY_NUMBER ="^[0-9]*S";
    public final String INPUT_CONTAIN_BLANK ="공백이 포함되어 있거나 빈 문자열입니다.";
    public final String CAR_NAME_EXCEED_FIVE_WORDS ="다섯 글자이하의 입력값이 아닙니다.";
    public final String ATTEMPT_NUMBER_CONTAIN_CHAR_OTHER_THAN_NUMBER = "시도 회수는 0이상의 정수만 입력하세요.";
    public void checkCarNameValidate(String input) {
        isNameOnlyComma(input);
        String[] carNames = input.split(",");
        for(String name: carNames) {
            isNameBelowFiveLetters(name);
            isNameContainBlank(name);
        }
    }

    public void checkNumOfAttempt(String input) {
        isNumContainBlank(input);
        isNumOnlyComposeNumber(input);
    }

    private void isNumOnlyComposeNumber(String input) {
        if(!Pattern.matches(REGEXP_PATTERN_ONLY_NUMBER,input)) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_CONTAIN_CHAR_OTHER_THAN_NUMBER);
        }
    }
    private void isNumContainBlank(String input) {
        if(!Pattern.matches(REGEXP_PATTERN_SPACE_NO_CHAR,input)) {
        throw new IllegalArgumentException(INPUT_CONTAIN_BLANK);
        }
    }
    private void isNameBelowFiveLetters(String input) {
        if(input.length()>NameConstant.MAX_LENGTH){
            throw new IllegalArgumentException(CAR_NAME_EXCEED_FIVE_WORDS);
        }
    }

    private void isNameContainBlank(String input){
        if(!Pattern.matches(REGEXP_PATTERN_SPACE_NO_CHAR,input)){
            throw new IllegalArgumentException("공백이 포함되어 있거나 빈 문자열입니다.");
        }
    }

    private void isNameOnlyComma(String input){
        if (Pattern.matches(REGEXP_PATTERN_ONLY_COMMA, input)) {
            throw new IllegalArgumentException(INPUT_CONTAIN_BLANK);
        }
    }
}
