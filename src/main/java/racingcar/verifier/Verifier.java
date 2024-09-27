package racingcar.verifier;

public interface Verifier<T> {

    public abstract void validate(T input);

    static void throwIllegalArgumentError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
