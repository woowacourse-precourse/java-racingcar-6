package racingcar.service;

// TODO: record로 변경 가능한 듯 함. 뭔지 자료조사하고, 적용가능하면 적용해볼 것
public class ResultDto {
    private final String name;
    private final Long totalMoveCount;

    public ResultDto(String name, Long totalMoveCount) {
        this.name = name;
        this.totalMoveCount = totalMoveCount;
    }

    public String getName() {
        return name;
    }

    public Long getTotalMoveCount() {
        return totalMoveCount;
    }

}
