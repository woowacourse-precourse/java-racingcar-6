package racingcar.dto;

public class CarDto {
    private String name;
    private Integer score;

    public CarDto(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
