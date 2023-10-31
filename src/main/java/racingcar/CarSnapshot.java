package racingcar;

public record CarSnapshot(String name, int position) {
    public static CarSnapshot from(Car car) {
        return new CarSnapshot(car.getName(), car.getPosition());
    }
}
