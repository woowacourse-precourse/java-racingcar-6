package racingcar.model.car;

public record CarId(Integer id) {
    public CarId {
        validateRange(id);
    }

    private void validateRange(int size) {
        if (size > Integer.MAX_VALUE || size < 0) {
            throw new IllegalArgumentException();
        }
    }
}