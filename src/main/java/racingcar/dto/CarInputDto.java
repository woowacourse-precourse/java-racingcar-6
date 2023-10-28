package racingcar.dto;

public class CarInputDto {
    private String name;

    public CarInputDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
