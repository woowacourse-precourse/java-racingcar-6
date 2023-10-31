package racingcar.model;

public record CarDTO(
        String name,
        int step

) {

    public static CarDTO of(String name, int step) {
        return new CarDTO(name, step);
    }
}
