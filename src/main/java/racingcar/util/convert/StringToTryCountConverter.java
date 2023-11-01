package racingcar.util.convert;

import racingcar.domain.TryCount;

import static racingcar.util.ErrorMessage.ONLY_NUMERIC_ERROR;

public class StringToTryCountConverter implements Converter<String, TryCount> {

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == TryCount.class;
    }

    @Override
    public TryCount convert(String target) {
        Integer value = toInt(target);
        return new TryCount(value);
    }

    private Integer toInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_ERROR.getMessage());
        }
    }
}
