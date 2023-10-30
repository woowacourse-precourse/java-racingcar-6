package racingcar.generator;

@FunctionalInterface
public interface Generator<T> {
	T generate();
}
