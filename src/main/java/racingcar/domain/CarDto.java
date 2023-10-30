package racingcar.domain;

public class CarDto {
    private String name;
    private int position;

    public CarDto(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
