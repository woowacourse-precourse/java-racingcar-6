package racingcar.controller;

public sealed interface FrontValidator permits InputValidator {
    String WRONG_NUMBER_ERROR_MESSAGE = "입력값은 숫자가 아닙니다.";
    String WRONG_WORDS_ERROR_MESSAGE = "delimiter를 제외한 부분에 특수 문자가 포함되어 있습니다.";
    String ENG_KOREAN_WORDS_PATTERN = "[a-zA-Z가-힣]+";
    void validateSingleNumber(String givenInput);
    void validateNamesByDelimiter(String givenInput, String delimiter);
}
