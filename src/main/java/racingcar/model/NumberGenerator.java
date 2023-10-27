package racingcar.model;

@FunctionalInterface
public interface NumberGenerator {

    int generateBetween(int min, int max);
}
