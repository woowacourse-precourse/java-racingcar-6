package racingcar.util;

@FunctionalInterface
public interface NumberGenerator {
    int generate(int min, int max);
}
