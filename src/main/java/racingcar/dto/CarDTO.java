package racingcar.dto;

public class CarDTO {
    private String name;
    private int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
