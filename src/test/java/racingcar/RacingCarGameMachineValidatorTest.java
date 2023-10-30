package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameMachineValidatorTest {
    private final String TOO_FEW_RACING_CAR_NAME_INPUT = "semin";
    private final String TOO_MANY_RACING_CAR_NAME_INPUT = "semin,woo,wa,tech,pre,cour,se";
    private final String CONTAINING_DUPLICATE_RACING_CAR_NAME_INPUT = "semin,semin";
    private final int TOO_SMALL_ROUND_COUNT = 0;
    private final int TOO_LARGE_ROUND_COUNT = 31;

    private RacingCarGameMachineValidator racingCarGameMachineValidator;

    @BeforeEach
    void init() {
        racingCarGameMachineValidator = new RacingCarGameMachineValidator();
    }

    @Test
    void 레이싱카_허용_개수_초과() {
        assertThatThrownBy(() -> callValidateNameInputMethod(TOO_MANY_RACING_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱카_허용_개수_미만() {
        assertThatThrownBy(() -> callValidateNameInputMethod(TOO_FEW_RACING_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름_포함() {
        assertThatThrownBy(() -> callValidateNameInputMethod(CONTAINING_DUPLICATE_RACING_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void callValidateNameInputMethod(String nameInput) {
        racingCarGameMachineValidator.validateNameInput(nameInput);
    }

    @Test
    void 최소_라운드_미만() {
        assertThatThrownBy(() -> callValidateRoundCountMethod(TOO_SMALL_ROUND_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대_라운드_초과() {
        assertThatThrownBy(() -> callValidateRoundCountMethod(TOO_LARGE_ROUND_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void callValidateRoundCountMethod(int tooLargeRoundCount) {
        racingCarGameMachineValidator.validateRoundCount(tooLargeRoundCount);
    }
}
