package racingcar.util.count;

public interface EqualityChecker {
    boolean countEquals(Object o);
    int  generateHashCode();
}
