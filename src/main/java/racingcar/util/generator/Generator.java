package racingcar.util.generator;

@FunctionalInterface
public interface Generator<T> {
    T generate();
}
