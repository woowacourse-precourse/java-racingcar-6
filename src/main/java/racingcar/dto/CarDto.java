package racingcar.dto;

public class CarDto {

    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
