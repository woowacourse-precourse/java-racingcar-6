package racingcar.utils.types;

import java.util.stream.Stream;

public class NumberUtils {

    private NumberUtils() {
        throw new UnsupportedOperationException();
    }


    public static <T extends Number & Comparable<T>> boolean isInRange(final T value, final T minValue, final T maxValue) {
        return minValue.compareTo(value) <= 0 && value.compareTo(maxValue) <= 0;
    }

}
