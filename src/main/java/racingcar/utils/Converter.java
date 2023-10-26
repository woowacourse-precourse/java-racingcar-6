package racingcar.utils;

@FunctionalInterface
public interface Converter<S, T> {

    T convert(S source);
}
