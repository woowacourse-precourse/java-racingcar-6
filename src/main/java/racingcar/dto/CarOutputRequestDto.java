package racingcar.dto;

public class CarOutputRequestDto {
    private final String name;
    private final int position;

    public CarOutputRequestDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
