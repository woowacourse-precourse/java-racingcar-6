package racingcar.util.count;

public sealed interface EqualityChecker permits EqualityCheckerImpl {
    boolean countEquals(Object o);
    int generateHashCode();
}
