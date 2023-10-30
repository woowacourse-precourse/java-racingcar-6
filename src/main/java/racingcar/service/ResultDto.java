package racingcar.service;

// TODO: record로 변경 가능한 듯 함. 뭔지 자료조사하고, 적용가능하면 적용해볼 것
public class ResultDto {
    private final String name;

    public ResultDto(String name, Long totalMoveCount) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
