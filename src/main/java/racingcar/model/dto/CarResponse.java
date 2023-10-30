package racingcar.model.dto;

public class CarResponse {

    private final String name;
    private final int position;

    private CarResponse(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static CarResponse of(final String name, final int position) {
        return new CarResponse(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
