package racingcar;

@FunctionalInterface
public interface RandomNumberGenerator {
	int generate(int min, int max);
}
