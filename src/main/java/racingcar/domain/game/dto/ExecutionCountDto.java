package racingcar.domain.game.dto;

public record ExecutionCountDto(Integer number) {
    public ExecutionCountDto {
        if(number == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        validateNumberIsPositive(number);
    }

    private void validateNumberIsPositive(Integer number) {
        if(number < 0) {
            throw new IllegalArgumentException("양수의 숫자를 입력해주세요");
        }
    }

}
