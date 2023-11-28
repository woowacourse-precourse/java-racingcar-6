package racingcar.validation;

import racingcar.model.Round;

import static racingcar.type.PlayType.MAX_NUM;
import static racingcar.type.PlayType.MIN_NUM;

public class RoundValidator implements Validator {
    public static final String VALID_RANGE = "^["+ MIN_NUM + "-" + MAX_NUM +"]+";
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
        if (value != null && !value.matches(VALID_RANGE)){
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String value){
        if (0 > Integer.parseInt(value)) {
            throw new IllegalArgumentException();
        }
    }
}
