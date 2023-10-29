package racingcar.model.car;
public class CarId {
    private final Integer id;
    public CarId(Integer id) {
        validateRange(id);
        this.id = id;
    }

    private void validateRange(int size) {
        if (size > Integer.MAX_VALUE || size < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getId() {
        return id;
    }
}