package racingcar.Model.Car;

public interface Id<T> {

    T IdRange();

    T generateId(T value);
}
