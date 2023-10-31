package racingcar.domain;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static racingcar.view.Constants.*;

public class NameValidation {

    private final String NAMES;
    //private final ArrayList<String> NAMES_ARRAY;

    public NameValidation(String names) {
        this.NAMES = names;
        isCorrectPattern();
    }

    // 정해진 포맷에 맞는 입력이 들어왔는지 먼저 확인한다. 쉼표로 구분되는 입력
    // 참고로 들어오는 모든 입력값들은 먼저 공백이 제거되어야 한다.
    // 아래의 정규식은 띄어쓰기를 허용하지 않음. -> trim으로 입력에서 한 번 걸러야 한다.
    public void isCorrectPattern() {
        // 오직 하나의 문자만 입력되거나, 한 개 이상일 경우 이름과 이름 사이에 쉼표(,)로 구분되어야 한다.
        // 쉼표는 오직 하나만 사용되며, 이름과 이름 사이 외의 다른 위치에는 허용되지 않는다.
        Pattern correctPattern = Pattern.compile(NAME_VALIDATION_REGEX.getMessage());
        if (!correctPattern.matcher(NAMES).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION.getMessage());
        }


    }

}
