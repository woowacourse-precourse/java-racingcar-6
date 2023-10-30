package racingcar.model.car;

public class CarId {
    private final int id;

    public CarId(int id) {
        validateId(id);
        this.id = id;
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
    }
}
