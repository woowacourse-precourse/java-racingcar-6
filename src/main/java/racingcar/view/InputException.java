package racingcar.view;

import java.util.regex.Pattern;

public class InputException {

    public void inputSeparatorException(String carNames) throws IllegalArgumentException{
        if(!Pattern.matches("^[a-z|A-Z|ㄱ-ㅎ|가-힣|,]+$",carNames))
           throw new IllegalArgumentException("쉽표(,)를 통해 구분해 주세요.");
    }
}
