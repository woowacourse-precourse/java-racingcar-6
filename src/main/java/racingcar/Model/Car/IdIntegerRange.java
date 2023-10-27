package racingcar.Model.Car;

public class IdIntegerRange<T> implements Id<T>{
    private int id;

    private IdIntegerRange(int id) {
        this.id = id;
    }

    @Override
    public T IdRange() {
        return null;
    }

    @Override
    public T generateId(T value) {
        return null;
    }
}
