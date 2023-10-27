package util.stringconverter;

public interface StringConverter<T> {
    public String toString(T object);
    public T fromString(String string);
}
