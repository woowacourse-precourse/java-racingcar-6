package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Utils {

    private static final int CAR_NAME_LENGTH_MIN = 1;
    private static final int CAR_NAME_LENGTH_MAX = 5;
    private static final String BLANK = " ";

    public List<String> parse_CAR_NAMES(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int parse_Trials_Numbers(String input) {
        return Integer.parseInt((input));
    }

    public void Check_CAR_NAMES_input(String input) throws IllegalArgumentException{
        Check_EMPTY_ThrowException(input);
        Check_CAR_INDEX_ThrowException(input);
        List<String> CAR_NAMES_LIST = parse_CAR_NAMES(input);
        Check_Car_NAMES_LIST_ThrowException_duplication(CAR_NAMES_LIST);
        Check_Car_NAMES_LIST_ThrowException_eachname(CAR_NAMES_LIST);
    }

    private void Check_EMPTY_ThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("올바른 값을 입력해주십시오.");
        }
    }

    private void Check_CAR_INDEX_ThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            CAR_NAME_MIN_ThrowException();
        }
    }
    private void CAR_NAME_MIN_ThrowException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LENGTH_MIN + "글자 이상으로 입력하십시오.");
    }

    private void CAR_NAME_MAX_ThrowException() {
        throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LENGTH_MAX + "글자 이하로 입력하십시오.");
    }

    private void Check_Car_NAMES_LIST_ThrowException_duplication(List<String> CAR_NAMES_LIST) {
        for (int i = 0; i < CAR_NAMES_LIST.size(); i++) {
            for (int j = i + 1; j < CAR_NAMES_LIST.size(); j++) {
                Check_CAR_NAMES_ThrowException_equals(CAR_NAMES_LIST.get(i), CAR_NAMES_LIST.get(j));
            }
        }
    }

    private void Check_CAR_NAMES_ThrowException_equals(String CAR_NAME_1, String CAR_NAME_2) {
        if (CAR_NAME_1.equals(CAR_NAME_2)) {
            throw new IllegalArgumentException("중복되는 이름은 사용할 수 없습니다.(이미 존재하는 이름임.)");
        }
    }

    private void Check_Car_NAMES_LIST_ThrowException_eachname(List<String> CAR_NAMES_LIST) {
        for (String CAR_NAME : CAR_NAMES_LIST) {
            Check_Length_ThrowException(CAR_NAME);
            Check_BLANK_ThrowException(CAR_NAME);
        }
    }

    private void Check_BLANK_ThrowException(String CAR_NAME) {
        if (CAR_NAME.contains(BLANK)) {
            BLANK_ThrowException();
        }
    }

    private void BLANK_ThrowException() {
        throw new IllegalArgumentException("띄어쓰기가 포함되지 않은 이름을 입력해주십시오.");
    }

    private void Check_Length_ThrowException(String CAR_NAME) {
        if (CAR_NAME_LENGTH_MAX < CAR_NAME.length()) {
            CAR_NAME_MAX_ThrowException();
        }
        if (CAR_NAME.length() < CAR_NAME_LENGTH_MIN) {
            CAR_NAME_MIN_ThrowException();
        }
    }

    public void Check_Trial_Numbers(String input) throws IllegalArgumentException {
        Check_EMPTY_ThrowException(input);
        Check_Char_ThrowException(input);
    }

    private void Check_Char_ThrowException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수를 숫자로 입력해주십시오.");
        }
    }


}
