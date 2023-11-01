package racingcar.model.dto;

public class CarDTO {
    protected final String name;
    protected int dist;

    public CarDTO(String name) {
        this.name = name;
        this.dist = 0;
    }

    public CarDTO(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(dist));
    }
}
