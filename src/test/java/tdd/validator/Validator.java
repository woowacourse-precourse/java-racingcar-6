package tdd.validator;

public interface Validator<T> {
    T validate(T input);
}