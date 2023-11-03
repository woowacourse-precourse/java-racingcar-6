package racingcar.model;

public record MoveResult(String name, int position) {

    public static MoveResult from(final Car car) {
        return new MoveResult(car.getName(), car.getPosition());
    }
}
