package racingcar.model.car;

public record CarId(int id) {
    public CarId {
        validateId(id);
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
    }
}
