package racingcar.domain.car;

public record CarName(String carName) {
    public CarName {
        validateCarNameLength(carName);
    }

    private static void validateCarNameLength(final String carName) {
        // TODO:
    }
}
