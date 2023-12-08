package racingcar.validation;

import racingcar.model.Round;

import java.util.regex.Pattern;

import static racingcar.type.PlayType.MAX_NUM;
import static racingcar.type.PlayType.MIN_NUM;
import static racingcar.type.message.ErrorMessageType.INVALID_TYPE;
import static racingcar.type.message.ErrorMessageType.INVALID_RANGE;

public class RoundValidator implements Validator {
    public static final String VALID_RANGE = "^["+ MIN_NUM + "-" + MAX_NUM +"]+";
    private static final Pattern NUMBER = Pattern.compile(VALID_RANGE);
    @Override
    public boolean support(Class<?> clazz) {
        return Round.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateType((String) target);
        validateRange((String) target);
    }

    private void validateType(String value){
//        if (value != null && !value.matches(VALID_RANGE)){
        if (value != null & !NUMBER.matcher(value).matches()){
            throw new IllegalArgumentException(INVALID_TYPE.getErrorMessageValue());
        }
    }

    private void validateRange(String value){
        if (0 > Integer.parseInt(value)) {
            throw new IllegalArgumentException(INVALID_RANGE.getErrorMessageValue());
        }
    }
}
