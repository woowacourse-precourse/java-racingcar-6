package racingcar_yoojaeyoongit.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validation.ValidateInput;

public class InputValidationTest {
    ValidateInput validateInput = new ValidateInput();
    @Test
    void 유저입력이_공백일_경우() {
        String ApplicantCarList = "";

        assertThatThrownBy(() -> validateInput.validateInPutApplicantCarList(ApplicantCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 지원 형식입니다. (공백을 입력하실 수 없습니다.)");
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car1,"})
    void 유저입력_자동차가_한_개_일_경우(String ApplicantCarList) {

        assertThatThrownBy(() -> validateInput.validateInPutApplicantCarList(ApplicantCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 지원 형식입니다. (최소 두 대의 자동차를 입력해야 합니다.)");
    }

    @Test
    void 이동_횟수_입력이_1미만인_경우() {
        int raceCount = 0;

        assertThatThrownBy(() -> validateInput.validateInputRaceCount(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주 횟수는 1회 이상이어야 합니다.");
    }
}
