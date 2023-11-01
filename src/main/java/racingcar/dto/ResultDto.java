package racingcar.dto;

public class ResultDto {
    private final String name;
    private final int position;

    public ResultDto(String name, int position) {
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
