package racingcar.model.Car;
public class CarId {
    private final Integer id;
    public CarId(Integer id) {
        validateRange(id);
        this.id = id;
    }

    public static IllegalArgumentException validateRange(int size) {
        if (size > Integer.MAX_VALUE || size < 0) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    public Integer getId() {
        return id;
    }
}