package racingcar.model.validator.carName;

/**
 * 자동차 이름의 유효성을 검증하는 규칙을 나타내는 interface이다.
 */
public interface CarNameValidator {

    /**
     * 자동차 이름 입력의 형식을 검증한다.
     *
     * @param carNamesFromUsers 검증할 자동차 이름 배열
     */
    void validateSyntax(String[] carNamesFromUsers);

    /**
     * 자동차 이름의 길이를 검증한다.
     *
     * @param carNamesFromUsers 검증할 자동차 이름 배열
     */
    void validateLength(String[] carNamesFromUsers);

    /**
     * 자동차 이름에 중복된 것이 있는지 검증한다.
     *
     * @param carNamesFromUsers 검증할 자동차 이름 배열
     */
    void validateDuplicate(String[] carNamesFromUsers);

    /**
     * 자동차 이름의 모든 것을 검증한다 : syntax, length, duplicate
     *
     * @param carNamesFromUsers 검증할 자동차 이름 배열
     */
    void validateAll(String[] carNamesFromUsers);
}
