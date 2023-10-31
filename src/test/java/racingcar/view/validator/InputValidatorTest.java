package racingcar.view.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    static final String CAR_NAME_LENGTH_LONGER_THAN_FIVE = "abcdef";
    static final String CAR_NAME_INVALID_LETTER = "!a ";
    static final String CAR_NAME_DUPLICATED = "abc,abc";
    static final String CAR_NAME_EMPTY_NAME = "a,,b";
    static final String CAR_NAME_PLAYER_LESS_THAN_TWO = "abc";
    static final String CAR_NAME_LAST_CHARACTER_IS_COMMA = "abc,";
    //
    static final String[] InvalidCarNames = {
            CAR_NAME_LENGTH_LONGER_THAN_FIVE,
            CAR_NAME_INVALID_LETTER,
            CAR_NAME_DUPLICATED,
            CAR_NAME_EMPTY_NAME,
            CAR_NAME_PLAYER_LESS_THAN_TWO,
            CAR_NAME_LAST_CHARACTER_IS_COMMA
    };

    static final String PLAYTIME_INVALID_LETTER = "aAbC-";
    static final String PLAYTIME_ZERO = "0";
    static final String PLAYTIME_GREATER_THAN_THOUSAND = "1001";
    static final String PLAYTIME_INTEGER_OVERFLOW = "4294967296";
    static final String[] InvalidPlayTime = {
            PLAYTIME_INVALID_LETTER,
            PLAYTIME_ZERO,
            PLAYTIME_GREATER_THAN_THOUSAND,
            PLAYTIME_INTEGER_OVERFLOW,
    };

    @Test
    @DisplayName("자동치 이름이 잘못된 입력일 경우 예외 발생 시키는지 판단")
    void Given_InvalidCarNames_When_ValidateNames_Then_ThrowsIllegalArgumentException() {
        try {
            for (String invalidCarNames : InvalidCarNames) {
                InputValidator.validateCarName(invalidCarNames);
            }
        } catch (Exception e) {
            assert (e instanceof IllegalArgumentException);
        }
    }

    @Test
    @DisplayName("게임 횟수가 잘못된 입력일 경우 예외 발생 시키는지 판단")
    void Given_InvalidPlaytime_When_ValidateNames_THEN_ThrowsIllegalArgumentException() {
        try {
            for (String invalidPlayTime : InvalidPlayTime) {
                InputValidator.validateCarName(invalidPlayTime);
            }
        } catch (Exception e) {
            assert (e instanceof IllegalArgumentException);
        }
    }
}