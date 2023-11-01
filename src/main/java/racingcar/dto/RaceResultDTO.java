package racingcar.dto;

public class RaceResultDTO {
    private final String name;
    private final Integer location;

    private RaceResultDTO(String name, Integer location) {
        this.name = name;
        this.location = location;
    }

    public static RaceResultDTO create(String name, Integer location) {
        return new RaceResultDTO(name, location);
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }
}
