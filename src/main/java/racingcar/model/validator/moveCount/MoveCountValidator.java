package racingcar.model.validator.moveCount;

/**
 * 총 이동 횟수를 검증하는 규칙을 나타내는 interface이다.
 */
public interface MoveCountValidator {

    /**
     * input이 올바른 형식인지 확인한다.
     *
     * @param input 검증할 이동 횟수
     */
    void validateType(Long input);

    /**
     * 이동 횟수가 양수인지 확인한다.
     *
     * @param input 검증할 이동 횟수
     */
    void validatePositive(Long input);

    /**
     * 이동 횟수의 모든 것을 검증한다 : type, positive
     *
     * @param input 검증할 이동 횟수
     */
    void validateAll(Long input);
}
