package racingcar.model.dto;

public class WinnerResponse {

    private final String name;

    private WinnerResponse(final String name) {
        this.name = name;
    }

    public static WinnerResponse from(final String name) {
        return new WinnerResponse(name);
    }

    public String getName() {
        return name;
    }
}
