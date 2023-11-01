package racingcar.dto;

// 사용자의 값을 입력받아 저장하기 위한 레코드
public record UserInput(
        String[] nameArr,
        int frequency
) {
    public UserInput(final String[] nameArr, final int frequency) {
        this.nameArr = nameArr;
        this.frequency = frequency;
    }
}