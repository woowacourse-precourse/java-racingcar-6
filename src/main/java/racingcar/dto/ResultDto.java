package racingcar.dto;

// TODO: record로 변경 가능한 듯 함. 뭔지 자료조사하고, 적용가능하면 적용해볼 것
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
