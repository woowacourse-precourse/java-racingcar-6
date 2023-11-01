package racingcar.model.dto;

public record CarResponse(String name, int position) {

    public static CarResponse of(final String name, final int position) {
        return new CarResponse(name, position);
    }
}
