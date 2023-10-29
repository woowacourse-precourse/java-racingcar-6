package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.Configuration;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TryNumberValidator;


public class RacingCarServiceTest {
    private final RacingCarService racingCarService = Configuration.racingCarService();
    private final TryNumberValidator tryNumberValidator = new TryNumberValidator();
    private final CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    public void 시도_회수_입력_검증_성공() {
        String validInput = "5";

        Assertions.assertDoesNotThrow(() -> racingCarService.inputValidate(validInput,tryNumberValidator));
    }

    @Test
    public void 자동차_이름_입력_검증_성공() {
        String validInput = "김명준";

        Assertions.assertDoesNotThrow(() -> racingCarService.inputValidate(validInput,carNameValidator));
    }


}

