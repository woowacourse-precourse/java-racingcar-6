package racingcar.dto;

public class MoveResultDto {
    private final String name;
    private final Integer location;

    private MoveResultDto(String name, Integer location) {
        this.name = name;
        this.location = location;
    }

    public static MoveResultDto make(String name, Integer location) {
        return new MoveResultDto(name, location);
    }
}
