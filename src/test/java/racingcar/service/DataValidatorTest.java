package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameInvalidException;
import racingcar.exception.TrialNumberInvalidException;

public class DataValidatorTest {
    DataValidator dataValidator;

    @BeforeEach
    void setUp() {
        dataValidator = new DataValidator();
    }

    @DisplayName("시도 횟수가 입력을 잘못하면 TrialNumberInvalidException을 발생시킨다.")
    @Test
    void validateTrialNumber() {
        Assertions.assertThrows(TrialNumberInvalidException.class,
                () -> dataValidator.validateTrialNumber("하이"));
    }

    @DisplayName("자동차 이름이 잘못(중복,5글자 초과)되면 예외을 발생시킨다.")
    @Test
    void validateCarName() {
        String[] overLength = {"123", "faasa", "aisjdiadai"};
        String[] duplication = {"k", "k", "kos"};
        Assertions.assertAll(
                () -> Assertions.assertThrows(CarNameInvalidException.class,
                        () -> dataValidator.validateCarName(overLength)),
                () -> Assertions.assertThrows(CarNameDuplicateException.class,
                        () -> dataValidator.validateCarName(duplication))
        );
    }
}
