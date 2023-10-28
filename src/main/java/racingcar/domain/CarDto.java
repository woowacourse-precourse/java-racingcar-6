package racingcar.domain;

public class CarDto {

    private String name;
    private int distance;

    private CarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarDto convertCarDto(String name, int distance) {
        return new CarDto(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

}
