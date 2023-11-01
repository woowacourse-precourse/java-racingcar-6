package util.stringconverter;

public interface StringConverter<T> {
    String toString(T object);

    T fromString(String string);
}
