package racingcar.model.converter.inputConverter;

public interface InputConverter<T> {
    T convertToType(String input);
}
