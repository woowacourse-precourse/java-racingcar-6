package racingcar.domain;

public record CarRecord(int id, String name, int position) {

    public static CarRecord of(int id, String name, int position) {
        return new CarRecord(id, name, position);
    }

    public static CarRecord from(Car car) {
        return new CarRecord(car.getId(), car.getName(), car.getPosition());
    }
}